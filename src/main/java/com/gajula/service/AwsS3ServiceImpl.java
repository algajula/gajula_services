package com.gajula.service;

import com.gajula.model.FileMetaData;
import com.gajula.model.ResponseBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;

@Service
public class AwsS3ServiceImpl implements AwsS3Service{
    private final static Logger admin = LogManager.getLogger(AwsS3ServiceImpl.class.getName());

    @Autowired
    S3Client s3Client;

    @Override
    public ResponseBean getListfromS3Bucket(String bucketName) throws Exception {
        ResponseBean response = new ResponseBean();
        try {
            admin.info("AWS S3 getListfromS3Bucket Start");
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
