package com.cwl.mail.controller;

import com.cwl.mail.entity.RespBean;
import io.minio.MinioClient;
import io.minio.policy.PolicyType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class FileController {
    /*
      endpoint:  http://localhost:9000 #MinIO服务所在地址
      bucketName: mail #存储桶名称
      accessKey: minioadmin #访问的key
      secretKey: minioadmin #访问的秘钥
     */
    @Value("${minio.endpoint}")
    private String endpoint;
    @Value("${minio.bucketName}")
    private String bucketName;
    @Value("${minio.accessKey}")
    private String accessKey;
    @Value("${minio.secretKey}")
    private String secretKey;
    @PostMapping("/uploadFile")
    //@CrossOrigin("*")//解决跨域访问
    public RespBean uploadFile(MultipartFile file){
        try {
            MinioClient minioClient = new MinioClient(endpoint,accessKey,secretKey);
            boolean exists = minioClient.bucketExists(bucketName);
            if(!exists) {
                minioClient.makeBucket(bucketName);
                minioClient.setBucketPolicy(bucketName, "*.*", PolicyType.READ_ONLY);
            }
            //设置存处对象名称
            String filename = file.getOriginalFilename();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            String objectName = simpleDateFormat.format(new Date())+"/"+filename;
            //把存储对象存存储桶中
            minioClient.putObject(bucketName,objectName,file.getInputStream(),file.getContentType());
            System.out.println("上传文件成功");

            String objectUrl = minioClient.getObjectUrl(bucketName,objectName);
            System.out.println(objectUrl);

            return RespBean.ok(objectUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("上传文件失败");
        }


    }
}
