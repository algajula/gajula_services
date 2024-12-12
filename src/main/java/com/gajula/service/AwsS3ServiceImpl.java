package com.gajula.service;

import com.gajula.model.FileMetaData;
import com.gajula.model.ResponseBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;
import software.amazon.awssdk.services.s3.paginators.ListObjectsV2Iterable;

import java.util.ArrayList;
import java.util.List;

@Service
public class AwsS3ServiceImpl implements AwsS3Service{
    private final static Logger admin = LogManager.getLogger(AwsS3ServiceImpl.class.getName());

    @Autowired
    S3Client s3Client;

    @Override
    public ResponseBean getListfromS3Bucket(String bucketName) throws Exception {
        ResponseBean response = new ResponseBean();
        List<String> keys = new ArrayList<>();
        try {
            admin.info("AWS S3 getListfromS3Bucket Start "+bucketName);
            ListObjectsV2Request s3req = ListObjectsV2Request.builder()
                    .bucket(bucketName)
                    //.prefix("*")
                    .build();
            ListObjectsV2Iterable s3res = s3Client.listObjectsV2Paginator(s3req);
            for (ListObjectsV2Response page : s3res) {
                page.contents().forEach((S3Object object) -> {
                    System.out.println(object.key());
                });
            }
            admin.info("Files found in bucket({}): {}", bucketName, keys);
            response.setResult(keys);
            admin.info("AWS S3 getListfromS3Bucket End");
        }catch (Exception e){
            admin.error("AWS S3 getListfromS3Bucket error "+e.getMessage());
        }
        return response;
    }

    @Override
    public ResponseBean UploadFileIntoS3Bucket(String bucketName, FileMetaData FileMetaData) throws Exception {
        ResponseBean response = new ResponseBean();
        try {
            admin.info("AWS S3 UploadFileIntoS3Bucket Start");
            admin.info("AWS S3 UploadFileIntoS3Bucket End");
        }catch (Exception e){
            admin.error("AWS S3 UploadFileIntoS3Bucket error "+e.getMessage());
        }
        return response;
    }

    @Override
    public ResponseBean downloadFileFromS3Bucket(String bucketName, FileMetaData FileMetaData) throws Exception {
        ResponseBean response = new ResponseBean();
        try {
            admin.info("AWS S3 downloadFileFromS3Bucket Start");
            admin.info("AWS S3 downloadFileFromS3Bucket End");
        }catch (Exception e){
            admin.error("AWS S3 downloadFileFromS3Bucket error "+e.getMessage());
        }
        return response;
    }
}
