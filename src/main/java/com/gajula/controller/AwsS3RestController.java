package com.gajula.controller;

import com.gajula.exception.CustomException;
import com.gajula.model.FileMetaData;
import com.gajula.model.RequestBean;
import com.gajula.model.ResponseBean;
import com.gajula.service.AwsS3Service;
import com.gajula.util.APIConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("/api/v1/aws/s3/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AwsS3RestController {
    private final static Logger admin = LogManager.getLogger(AwsS3RestController.class.getName());

    @Autowired
    AwsS3Service awsS3Service;

    @GetMapping(value = "/lists3files", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBean lists3files(@RequestBody(required = true) String reqStr) throws Exception {
        ResponseBean response = new ResponseBean();
        try {
            admin.info("===lists3files START===");
            RequestBean request  = APIConstants.getObjectMapper().readValue(reqStr, RequestBean.class);
            admin.info("Request Json==="+reqStr);
            List<FileMetaData> s3files = awsS3Service.getListfromS3Bucket(request.getBucketName());
            response.setResult(s3files);
            admin.info("===lists3files END===");
        } catch (Exception e) {
            throw new CustomException("error occured in lists3files service" + e.getMessage());
        }
        return response;
    }

    @GetMapping(value = "/downloads3file")
    public void downloadFileFromS3Bucket(
            //@RequestBody(required = true) String reqStr,
            @RequestParam("bucketName")String bucketName,
            @RequestParam("fileName")String fileName,
            @RequestParam("fileType")String fileType,
            HttpServletRequest httpReq, HttpServletResponse httpRes) throws Exception {
        FileMetaData response = new FileMetaData();
        try {
            admin.info("===downloadFileFromS3Bucket START===");

            //String bucketName = httpReq.getParameter("bucketName");
            //String fileName = httpReq.getParameter("fileName");
            //String fileType = httpReq.getParameter("fileType");

            //RequestBean request  = APIConstants.getObjectMapper().readValue(reqStr, RequestBean.class);
            //admin.info("Request Json==="+reqStr);

            RequestBean request= new RequestBean();
            request.setBucketName(bucketName);
            request.setFileName(fileName);
            request.setFileType(fileType);
            String reqStr  = APIConstants.getObjectMapper().writeValueAsString(request);
            admin.info("Request Json==="+reqStr);

            response = awsS3Service.downloadFileFromS3Bucket(request);

            httpRes.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+request.getFileName()+"."+request.getFileType());
            //httpRes.addHeader(HttpHeaders.CONTENT_LENGTH, response.getContentLength());
            httpRes.addHeader(HttpHeaders.CONTENT_TYPE, "application/octet-stream");
            httpRes.addHeader(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
            httpRes.addHeader(HttpHeaders.PRAGMA, "no-cache");
            httpRes.addHeader(HttpHeaders.EXPIRES, "0");
            httpRes.setContentType("application/octet-stream");
            response.setContentLength(response.getContentLength());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(response.getFile()));
            FileCopyUtils.copy(inputStream, httpRes.getOutputStream());
            admin.info("===downloadFileFromS3Bucket END===");
        } catch (Exception e) {
            throw new CustomException("error occured in downloadFileFromS3Bucket service" + e.getMessage());
        }
    }
}
