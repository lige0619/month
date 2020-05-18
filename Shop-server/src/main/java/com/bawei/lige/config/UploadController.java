package com.bawei.lige.config;

import com.bawei.lige.entity.ResultEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @RequestMapping("/upload")
    public ResultEntity upload(MultipartFile file){
        try {
            //判断上传文件是否为空          
            if (!file.isEmpty()) { 
                //获取文件名称              
                String originalFilename = file.getOriginalFilename();
                //定义上传后的文件名称     
                String fileName = UUID.randomUUID() + "_" + originalFilename;
                //目标文件        
                File distFile = new File("D:\\pic", fileName);
                //判断目标文件的父目录是否存在            
                if (!distFile.getParentFile().exists()) {
                    //创建所有的目录    
                    distFile.getParentFile().mkdirs();
                     }
                 file.transferTo(distFile);
                //返回结果              
                String userface = "http://localhost:8182/"+fileName;
                //返回上传成功后的url地址        
                return ResultEntity.ok(userface);
                   }
               }catch (IOException ex){  ex.printStackTrace();
                    return ResultEntity.error();
                   }
                 //返回结果    
                 return ResultEntity.error();
    }
}
