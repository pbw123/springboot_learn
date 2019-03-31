package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 潘炳稳 on 2019/3/25.
 * 上传文件控制器
 */
@Controller
public class UploadController {
    //指定一个临时路径作为上传目录
    private static String UPLOAD_FOLDER = "D:/temp/";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    //跳转到页面
    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile srcFile
            , RedirectAttributes redirectAttributes) {
        if (srcFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "请选择一个文件");
            return "redirect:upload_status";
        }
        //选择文件，开始进行上传操作
        try {
            //构建上传目标路径,找到项目的target的classes目录
            File destFile = new File(ResourceUtils.getURL("classpath:").getPath());
            String fileName= srcFile.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            fileName= UUID.randomUUID() +suffixName;
            if (!destFile.exists()) {
                destFile = new File("");
            }

//            目标文件的绝对路径
            System.out.println("file path:" + destFile.getAbsolutePath());
            //拼接static目录
            File upload = new File(destFile.getAbsolutePath(), df.format(new Date())+"/");

            if (!upload.exists()) {
                upload.mkdirs();
            }

            //根据srcFile的大小，准备一个byte数组
            byte[] bytes = srcFile.getBytes();
            //拼接上传路径
//            Path path = Paths.get(UPLOAD_FOLDER + srcFile.getOriginalFilename());
//            通过项目路径拼接上传路径
            Path path = Paths.get(upload.getAbsolutePath()+"/" +fileName);
            System.out.println("upload path:"+path);
            //最重要的一步，将源文件写入目标地址
            Files.write(path, bytes);
            // 将文件上传成功的信息写入目标地址
            redirectAttributes.addFlashAttribute("message",
                    "文件上传成功" + srcFile.getOriginalFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/upload_status";
    }

    //匹配upload_status页面
    @GetMapping("/upload_status")
    public String uploadStatus() {
        return "upload_status";
    }
}
