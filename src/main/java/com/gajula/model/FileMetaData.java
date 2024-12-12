package com.gajula.model;

import java.io.InputStream;
import java.io.Serializable;

public class FileMetaData implements Serializable {

    private String bucketName;
    private String keyName;
    private String keyType;
    private Long contentLength;
    private String contentType;
    private InputStream value;

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

    public InputStream getValue() {
        return value;
    }

    public void setValue(InputStream value) {
        this.value = value;
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
                '}';
    }
}
