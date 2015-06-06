package com.fh.taolijie.controller;

import cn.fh.security.credential.Credential;
import cn.fh.security.utils.CredentialUtils;
import com.alibaba.fastjson.JSON;
import com.fh.taolijie.controller.dto.GeneralMemberDto;
import com.fh.taolijie.controller.dto.JobPostDto;
import com.fh.taolijie.controller.dto.SecondHandPostCategoryDto;
import com.fh.taolijie.controller.dto.SecondHandPostDto;
import com.fh.taolijie.service.*;
import com.fh.taolijie.utils.Constants;
import com.fh.taolijie.utils.ControllerHelper;
import com.fh.taolijie.utils.ObjWrapper;
import com.fh.taolijie.utils.ResponseUtils;
import com.fh.taolijie.utils.json.JsonWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wynfrith on 15-4-1.
 */
@Controller
@RequestMapping("/user/sh")
public class SHController{

    @Autowired
    SHPostService shPostService;
    @Autowired
    SHPostCategoryService shPostCategoryService;
    @Autowired
    AccountService accountService;




    /**
     * 发布二手
     * @param
     * @return
     */
    @RequestMapping(value = "/post" ,method = RequestMethod.GET)
    public String postSH(HttpSession session,
                      Model model){
        List<SecondHandPostCategoryDto> cateList= shPostCategoryService.getCategoryList(0,Integer.MAX_VALUE,new ObjWrapper());
        model.addAttribute("cates",cateList);
      return "pc/user/shpost";
    }

    /**
     * 发布二手信息
     * @param shDto
     * @param session
     * @return
     */
    @RequestMapping(value = "/post", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody
    String job(@RequestParam String picIds,
            @Valid SecondHandPostDto shDto,
               BindingResult result,
               HttpSession session){
        GeneralMemberDto mem = null;

        if (result.hasErrors()) {
            return new JsonWrapper(false, result.getAllErrors()).getAjaxMessage();
        }
        String username = CredentialUtils.getCredential(session).getUsername();
        mem = accountService.findMember(username, new GeneralMemberDto[0], false);

        /*创建二手信息*/
        shDto.setMemberId(mem.getId());
        shDto.setPostTime(new Date());
        //图片列表  用分号隔开
        shDto.setPicturePath(picIds);

        if(shDto.getCategoryId()!=null){
            shPostService.addPost(shDto);
        }else {
            return new JsonWrapper(false,Constants.ErrorType.PARAM_ILLEGAL).getAjaxMessage();
        }
        return new JsonWrapper(true, Constants.ErrorType.SUCCESS).getAjaxMessage();
    }


    /**
     * 我的二手列表 GET
     * @param session 用户的角色
     * @return
     */
    @RequestMapping(value = "mypost", method = RequestMethod.GET)
    public String mypost(@RequestParam (defaultValue = "1") int page,
                         @RequestParam (defaultValue = Constants.PAGE_CAPACITY+"") int capacity,
                         HttpSession session, Model model){
        Credential credential = CredentialUtils.getCredential(session);
        ObjWrapper objWrapper = new ObjWrapper();
        int totalPage = 0;
        List<SecondHandPostDto> shs = shPostService.getPostList(credential.getId(),false,page-1,capacity,objWrapper);
        totalPage = (Integer)objWrapper.getObj();

        //TODO : 兼职列表没有memberDto是空的
        model.addAttribute("shs",shs);
        model.addAttribute("page",page);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("isFav",false);

        return "pc/user/shlist";
    }


    /**
     * 获取发布的二手列表 Ajax GET
     * @param page  页码数
     * @param session 用户的信息
     * @return
     */
    @RequestMapping(value = "list/{page}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public @ResponseBody String mySHList(@PathVariable int page,HttpSession session){
        int capcity = Constants.PAGE_CAPACITY;
        Credential credential = CredentialUtils.getCredential(session);

        GeneralMemberDto mem = accountService.findMember(credential.getUsername(), new GeneralMemberDto[0], false);

        List<SecondHandPostDto> list = shPostService.getPostList(mem.getId(),false,page-1,capcity,new ObjWrapper());
        return JSON.toJSONString(list);
    }




    /**
     * 获取已删除的二手列表 Ajax GET
     * @param page 页码数
     * @param session 用户的信息
     * @return
     */
    @RequestMapping(value = "dellist/{page}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public @ResponseBody String delList(@PathVariable int page,HttpSession session){
        return "";
    }


    /**
     * 获取带审核的二手列表 Ajax GET
     * @param page 页码数
     * @param session 用户的信息
     * @return
     */
    @RequestMapping(value = "auditlist/{page}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public @ResponseBody String auditList(@PathVariable int page,HttpSession session){
        return "";
    }


    /**
     * 删除一条二手信息
     * @param id 兼职的id
     * @param session  用户的信息
     * @return
     */
    @RequestMapping(value = "del/{id}",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody String del(@PathVariable int id,HttpSession session,
                                    @RequestParam(required = false) String ids){
        Credential credential = CredentialUtils.getCredential(session);


           /*删除多个*/
        if(id == 0 && (ids != null && !ids.equals(""))){
            try{
                for(String i : ids.split(";")){
                    int currId = Integer.parseInt(i);
                    SecondHandPostDto sh = shPostService.findPost(currId);
                    if(!ControllerHelper.isCurrentUser(credential,sh)){
                        return new JsonWrapper(false, Constants.ErrorType.PERMISSION_ERROR).getAjaxMessage();
                    }
                    shPostService.deletePost(currId);
                }
            }catch (Exception e){
                System.out.println("mutideleteError");
                return new JsonWrapper(false, Constants.ErrorType.FAILED).getAjaxMessage();
            }

        }

        /*删除*/
        else {
            SecondHandPostDto sh =shPostService.findPost(id);

        /*判断兼职信息是否由当前用户发布*/
            if(!ControllerHelper.isCurrentUser(credential,sh)){
                return new JsonWrapper(false, Constants.ErrorType.PERMISSION_ERROR).getAjaxMessage();
            }
            if (!shPostService.deletePost(id)) {
                return new JsonWrapper(false, Constants.ErrorType.FAILED).getAjaxMessage();
            }

        }

        return new JsonWrapper(true, Constants.ErrorType.SUCCESS).getAjaxMessage();
    }


    /**
     * 修改二手页面
     * @param id 传入一个二手所有信息
     * @param session 用户的信息
     * @param model
     * @return
     */
    @RequestMapping(value = "change",method = RequestMethod.GET)
    public String change(@RequestParam int id,HttpSession session,Model model){
        /**
         * 如果该job不是用户发送的,则返回404
         */
        Credential credential = CredentialUtils.getCredential(session);
        SecondHandPostDto sh=shPostService.findPost(id);
        if(sh == null|| !ControllerHelper.isCurrentUser(credential,sh)){
            return "redirect:/404";
        }

        model.addAttribute("sh",sh);
        return "mobile/shdetail";
    }

    /**
     * 修改一条二手 ajax
     * @param sh 二手的dto对象
     * @param session  用户的信息
     * @return
     */
    @RequestMapping(value = "change",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody String change(@Valid SecondHandPostDto sh,HttpSession session){
        /**
         * 如果该job不是用户发送的,则错误json
         */
        SecondHandPostDto oldsh = shPostService.findPost(sh.getId());
        sh.setMemberId(oldsh.getMemberId());
        Credential credential = CredentialUtils.getCredential(session);

        if(sh == null|| !ControllerHelper.isCurrentUser(credential,sh)){
            return  new JsonWrapper(false, Constants.ErrorType.PERMISSION_ERROR).getAjaxMessage();
        }

        if(!shPostService.updatePost(sh.getId(), sh)){
            return new JsonWrapper(false, Constants.ErrorType.ERROR).getAjaxMessage();
        }

        return new JsonWrapper(true, Constants.ErrorType.SUCCESS).getAjaxMessage();
    }

    /**
     * 刷新二手 数据 ajax
     * 更新一下posttime
     * @param id 二手 id
     * @param session  用户的信息
     */
    @RequestMapping(value = "refresh",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody String refresh(@RequestParam int id,HttpSession session){
        /**
         * 如果该sh不是用户发送的,则错误json
        */

        Credential credential = CredentialUtils.getCredential(session);
        SecondHandPostDto sh =shPostService.findPost(id);
        if(sh == null) {
            return new JsonWrapper(false, Constants.ErrorType.NOT_FOUND).getAjaxMessage();
        }

        if(!ControllerHelper.isCurrentUser(credential,sh)){
            return  new JsonWrapper(false, Constants.ErrorType.PERMISSION_ERROR).getAjaxMessage();
        }

        sh.setPostTime(new Date());
        if(!shPostService.updatePost(sh.getId(), sh)){
            return new JsonWrapper(false, Constants.ErrorType.ERROR).getAjaxMessage();
        }

        return new JsonWrapper(true, Constants.ErrorType.SUCCESS).getAjaxMessage();
    }

    /**
     * 我收藏的二手 get
     * @param session
     * @return
     */

    @RequestMapping(value = "myfav" ,method = RequestMethod.GET)
    public String fav(HttpSession session, Model model){
        Credential credential = CredentialUtils.getCredential(session);
        List<SecondHandPostDto> shs = new ArrayList<>();

        GeneralMemberDto memberDto = accountService.findMember(credential.getId());
        String favIds = memberDto.getFavoriteShIds();
        if(favIds != null && !favIds.equals("")){
            for(String fid : favIds.split(";")){
                SecondHandPostDto sh;
                try{
                    sh =shPostService.findPost(Integer.parseInt(fid));
                }catch (Exception e){
                    sh = null;
                }
                if(sh != null)
                    shs.add(sh);
            }
        }

        //TODO : 兼职列表没有memberDto是空的
        model.addAttribute("shs",shs);
        model.addAttribute("isFav",true);
        return "pc/user/shlist";
    }


    /**
     * 收藏一条兼职
     */
    @RequestMapping(value = "/fav/{id}",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    //region 收藏一条兼职 fav
    public @ResponseBody String fav (@PathVariable int id,HttpSession session){
        Credential credential = CredentialUtils.getCredential(session);
        if(credential == null)
            return  new JsonWrapper(false, Constants.ErrorType.PERMISSION_ERROR).getAjaxMessage();
        if(shPostService.findPost(id) == null)
            return  new JsonWrapper(false, Constants.ErrorType.NOT_FOUND).getAjaxMessage();

        //遍历用户的收藏列表
        //如果没有这条兼职则添加,反之删除
        GeneralMemberDto mem = accountService.findMember(credential.getId());
        String[] favIds = {};
        if(mem.getFavoriteShIds() != null)
            favIds = mem.getFavoriteShIds() .split(";");
        String favid = "";
        for(String fId : favIds){
            if(fId.equals(id+"")){
                favid = fId;
                break;
            }
        }
        String status;
        if(favid.equals("")){ //没有找到,则添加收藏
            shPostService.favoritePost(credential.getId(),id);
            status = "0";
        }else{ //否则删除收藏
            shPostService.unfavoritePost(credential.getId(),id);
            status = "1";
        }
        return new JsonWrapper(true, "status",status).getAjaxMessage();
    }
    //endregion

    /**
     * 取消收藏一条兼职 或多条
     */
    @RequestMapping(value = "/del/fav",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody String fav (HttpSession session,
                                     @RequestParam(required = false) String ids){
        Credential credential = CredentialUtils.getCredential(session);

        /*删除一个或多个*/
        try{
            for(String i : ids.split(";")){
                int currId = Integer.parseInt(i);
                shPostService.unfavoritePost(credential.getId(), currId);
            }
        }catch (Exception e){
            System.out.println("mutideleteError");
            return new JsonWrapper(false, Constants.ErrorType.FAILED).getAjaxMessage();
        }
        return new JsonWrapper(true, Constants.ErrorType.SUCCESS).getAjaxMessage();
    }

}
