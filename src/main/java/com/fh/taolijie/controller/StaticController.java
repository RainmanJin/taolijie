package com.fh.taolijie.controller;

import com.fh.taolijie.controller.dto.ImageDto;
import com.fh.taolijie.service.ImageService;
import com.fh.taolijie.utils.Constants;
import com.fh.taolijie.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/**
 * 该控制器用来存取一些静态资源文件，如果图片等
 * Created by wynfrith on 15-3-31.
 */
@RequestMapping("/static")
@Controller
public class StaticController {
    private static int _500KB = 1024 * 500;// 500KB

    @Autowired
    ImageService imageService;

    /**
     * 获取图片
     * 根据格式的不同会转发到对应格式的控制器
     * 如果格式不支持返回错误的json信息
     *
     * @param imageStr 图片名字 imageStr = id+ext
     *
     * @return
     */
    @RequestMapping(value = "images/users/{id}",method = RequestMethod.GET)
    public void getPic(@PathVariable int id,
                         HttpServletResponse res) throws IOException {
        ImageDto img = imageService.findImage(id);

        byte[] bytes = img.getBinData();
        String type = "image/"+img.getExtension();
        res.setContentType(type);
        res.setHeader("Cache-control","max-age=20");
        OutputStream out = res.getOutputStream();
        out.write(bytes);
        out.flush();
        out.close();
    }

    /**
     * 上传图片options方法验证
     */
    @RequestMapping(value = "upload", method =RequestMethod.OPTIONS, produces = "application/json; charset=utf-8")
    public @ResponseBody String uploadOptions(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        return "{code:0}";
    }

    /**
     * 用户上传图片
     * @return
     */
    @RequestMapping(value = "upload", method =RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody String upload(@RequestParam MultipartFile file,
                                       HttpServletResponse response) {

        ImageDto imageDto = new ImageDto();
        response.setHeader("Access-Control-Allow-Origin", "*");

        try (InputStream inStream = file.getInputStream()) {
            // 读取byte数据
            byte[] imageByte = writeToBuffer(inStream, file.getSize());
            if (null == imageByte) {
                // 不是图片文件
                inStream.close();
                return "invalid image!";
            }

            imageDto.setBinData(imageByte);

            String fileName = file.getOriginalFilename();
            String fileExt = getExtensionName(fileName);

            imageDto.setFileName(fileName);
            imageDto.setExtension(fileExt);

            // 写入数据库
            Integer imageId = imageService.saveImage(imageDto);
            System.out.println(imageId);
            // 返回成功信息

        } catch (IOException ex) {
            // 返回上传失败错误信息
            System.out.println("error!!!!!!!!!!!!!!!!!!!!!!!!");
        }

        return "savepic";
    }



    private byte[] writeToBuffer(InputStream in, Long size) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(size.intValue());
        int len = 0;

        // 先读10 bytes
        // 验证是否是png, jpg或gif
        byte[] validationBuf = new byte[10];
        in.read(validationBuf);
        if (Constants.ImageType.UNSUPPORTED == ImageUtils.getImageType(validationBuf)) {
            return null;
        }
        buffer.put(validationBuf);


        byte[] buf = new byte[_500KB];
        while ( (len = in.read(buf)) != -1 ) {
            buffer.put(buf, 0, len);
        }


        return buffer.array();
    }



    /**
     * 获得文件扩展名
     * @param filename
     * @return
     */
    private static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

}
