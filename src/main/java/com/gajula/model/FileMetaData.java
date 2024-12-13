package com.gajula.model;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class FileMetaData implements Serializable {

    private String bucketName;
    private String keyName;
    private String keyType;
    private Long contentLength;
    private String contentType;
    private OutputStream value;
    private InputStream fileIn;
    private OutputStream fileOut;
    private File file;

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public Long getContentLength() {
        return contentLength;
    }

    public void setContentLength(Long contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public OutputStream getValue() {
        return value;
    }

    public void setValue(OutputStream value) {
        this.value = value;
    }

    public InputStream getFileIn() {
        return fileIn;
    }

    public void setFileIn(InputStream fileIn) {
        this.fileIn = fileIn;
    }

    public OutputStream getFileOut() {
        return fileOut;
    }

    public void setFileOut(OutputStream fileOut) {
        this.fileOut = fileOut;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "FileMetaData{" +
                "bucketName='" + bucketName + '\'' +
                ", keyName='" + keyName + '\'' +
                ", keyType='" + keyType + '\'' +
                ", contentLength=" + contentLength +
                ", contentType='" + contentType + '\'' +
                ", value=" + value +
                ", fileIn=" + fileIn +
                ", fileOut=" + fileOut +
                ", file=" + file +
                '}';
    }
}
