package com.gajula.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;

@Component
public class GajulaAwsCredentialsProvider implements AwsCredentialsProvider {

    @Value("${gajula.aws.username}")
    private String accessKey;
    @Value("${gajula.aws.password}")
    private String accessSecret;

    @Override
    public AwsCredentials resolveCredentials() {
        return new AwsCredentials() {
            @Override
            public String accessKeyId() {
                return accessKey;
            }
            @Override
            public String secretAccessKey() {
                return accessSecret;
            }
        };
    }
}