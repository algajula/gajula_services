package com.gajula.service;

import com.gajula.model.FileMetaData;
import com.gajula.model.ResponseBean;

public interface AwsS3Service {

    public ResponseBean getListfromS3Bucket(String bucketName) throws Exception;
    public ResponseBean UploadFileIntoS3Bucket(String bucketName, FileMetaData FileMetaData) throws Exception;
    public ResponseBean downloadFileFromS3Bucket(String bucketName, FileMetaData FileMetaData) throws Exception;

}
