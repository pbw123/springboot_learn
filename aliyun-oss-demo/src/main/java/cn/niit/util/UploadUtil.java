package cn.niit.util;

import com.aliyun.oss.OSSClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 潘炳稳 on 2019/4/15.
 */
@RestController
public class UploadUtil {
        @GetMapping(value = "/")
        public ModelAndView index()
        {
            return new ModelAndView("upload.html");
        }

        @PostMapping("/avatar/upload")
        public String ossUpload(@RequestParam("file") MultipartFile sourceFile) {
            String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
            String accessKeyId = "LTAIelFvJkV74tTC";
            String accessKeySecret = "PumKvfJwNZPO8F2WHfg8lwgjKhKjLL";
            String bucketName = "save-pan";
            String filedir = "img/";
            // 获取文件名
            String fileName = sourceFile.getOriginalFilename();
            // 获取文件后缀
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            //uuid生成主文件名
            String prefix = UUID.randomUUID().toString();
            String newFileName = prefix + suffix;
            File tempFile = null;
            try {
                //创建临时文件
                tempFile = File.createTempFile(prefix, prefix);
                // MultipartFile to File
                sourceFile.transferTo(tempFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            ossClient.putObject(bucketName, filedir + newFileName, tempFile);
            Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
            // 生成URL
            URL url = ossClient.generatePresignedUrl(bucketName, filedir + newFileName, expiration);
            ossClient.shutdown();
            return url.toString();
        }
    }