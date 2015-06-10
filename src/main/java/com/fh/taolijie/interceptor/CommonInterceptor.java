package com.fh.taolijie.interceptor;

import com.fh.taolijie.controller.dto.JobPostCategoryDto;
import com.fh.taolijie.controller.dto.NewsDto;
import com.fh.taolijie.controller.dto.SecondHandPostCategoryDto;
import com.fh.taolijie.service.JobPostCateService;
import com.fh.taolijie.service.NewsService;
import com.fh.taolijie.service.ResumeService;
import com.fh.taolijie.service.SHPostCategoryService;
import com.fh.taolijie.utils.ObjWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wynfrith on 15-5-18.
 */

@Component
public class CommonInterceptor  extends HandlerInterceptorAdapter{
    @Autowired
    NewsService newsService;
    @Autowired
    JobPostCateService jobPostCateService;
    @Autowired
    SHPostCategoryService shPostCategoryService;
    @Autowired
    ResumeService resumeService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //首页新闻
        List<NewsDto> list = newsService.getNewsList(0,3, new ObjWrapper());
        //首页兼职二手分类(简历和兼职分类相同)
        List<JobPostCategoryDto> jobs = jobPostCateService.getCategoryList(0,9999,new ObjWrapper());
        List<SecondHandPostCategoryDto> shs = shPostCategoryService.getCategoryList(0,9999,new ObjWrapper());
        request.setAttribute("titles",list);
        request.setAttribute("sideJobCate",jobs);
        request.setAttribute("sideSHCate",shs);
        request.setAttribute("sideResumeCate",jobs);
        return  true;
    }

}
