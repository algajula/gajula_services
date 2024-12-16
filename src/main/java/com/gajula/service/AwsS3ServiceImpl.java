package com.gajula.service;

import com.gajula.model.FileMetaData;
import com.gajula.model.RequestBean;
import com.gajula.model.ResponseBean;
import com.gajula.util.APIConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;
import software.amazon.awssdk.services.s3.paginators.ListObjectsV2Iterable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class AwsS3ServiceImpl implements AwsS3Service{
    private final static Logger admin = LogManager.getLogger(AwsS3ServiceImpl.class.getName());

    @Autowired
    S3Client s3Client;

    @Override
    public List<FileMetaData> getListfromS3Bucket(String bucketName) throws Exception {
        List<FileMetaData> s3files = new ArrayList<FileMetaData>();
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
                    System.out.println(object);
                    FileMetaData metaData = new FileMetaData();
                    metaData.setBucketName(bucketName);
                    String fileName = APIConstants.getBaseFileName(object.key());
                    String fileType = APIConstants.getFileExtension(object.key());
                    metaData.setKeyName(fileName);
                    metaData.setKeyType(fileType);
                    s3files.add(metaData);
                    //keys.add(object.key());
                });
            }
            admin.info("Files found in bucket({}): {}", bucketName, keys);
            admin.info("AWS S3 getListfromS3Bucket End");
            return s3files;
        }catch (Exception e){
            admin.error("AWS S3 getListfromS3Bucket error "+e.getMessage());
        }
        return s3files;
    }

    @Override
    public ResponseBean UploadFileIntoS3Bucket(String bucketName, FileMetaData fileMetaData) throws Exception {
        ResponseBean response = new ResponseBean();
        try {
            admin.info("AWS S3 UploadFileIntoS3Bucket Start");
            String fileName = fileMetaData.getKeyName()+"."+fileMetaData.getKeyType();
            PutObjectRequest objectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(fileName)
                    .contentType("application/pdf")
                    .build();
            String tempDir = System.getProperty("java.io.tmpdir");
            File file = new File(tempDir+fileName);
            admin.info("File path===="+file.getAbsolutePath());
            try(OutputStream outputStream = new FileOutputStream(file)) {
                IOUtils.copy(fileMetaData.getFileIn(), outputStream);
            }
            admin.info("create a file");
            PutObjectResponse s3res = s3Client.putObject(objectRequest, Paths.get(file.toURI()));
            String versionId = s3res.versionId();
            admin.info("AWS S3 UploadFileIntoS3Bucket End versionId "+versionId);
        }catch (Exception e){
            admin.error("AWS S3 UploadFileIntoS3Bucket error "+e.getMessage());
        }
        return response;
    }

    @Override
    public FileMetaData downloadFileFromS3Bucket(RequestBean request) throws Exception {
        FileMetaData response = new FileMetaData();
        try {
            admin.info("AWS S3 downloadFileFromS3Bucket Start");
            response = getObjectBytes(request);
            admin.info("AWS S3 downloadFileFromS3Bucket End");
        }catch (Exception e){
            admin.error("AWS S3 downloadFileFromS3Bucket error "+e.getMessage());
        }
        return response;
    }

    public FileMetaData getObjectBytes(RequestBean request)throws Exception {
        FileMetaData metadata = new FileMetaData();
        String filename = request.getFileName()+"."+request.getFileType();
        GetObjectRequest objectRequest = GetObjectRequest.builder()
                .key(request.getFileName()+"."+request.getFileType())
                .bucket(request.getBucketName())
                .build();
        ResponseBytes<GetObjectResponse> objectBytes = s3Client.getObjectAsBytes(objectRequest);
        byte[] data = objectBytes.asByteArray();
        String tempDir = System.getProperty("java.io.tmpdir");
        File file = new File(tempDir+filename);
        admin.info("File path===="+file.getAbsolutePath());
        OutputStream os = new FileOutputStream(file);
        os.write(data);
        admin.info("Successfully obtained bytes from an S3 object");
        os.close();
        metadata.setFile(file);
        return metadata;
    }
}
