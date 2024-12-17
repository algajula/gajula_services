package com.gajula.service;

import com.gajula.model.FileMetaData;
import com.gajula.model.RequestBean;
import com.gajula.model.ResponseBean;

import java.util.List;

public interface AwsS3Service {

    public List<FileMetaData> getListfromS3Bucket(String bucketName) throws Exception;
    public ResponseBean UploadFileIntoS3Bucket(String bucketName, FileMetaData FileMetaData) throws Exception;
    public FileMetaData downloadFileFromS3Bucket(RequestBean request) throws Exception;
    public ResponseBean deletes3file(RequestBean request) throws Exception;

}
