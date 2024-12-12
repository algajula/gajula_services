package com.gajula.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AWSResourcesConfiguration {

    private final static Logger admin = LogManager.getLogger(AWSResourcesConfiguration.class.getName());

    @Value("${gajula.cloud.aws.region.static}")
    private String region;

    @Bean(name = "s3Client")
    public S3Client s3Client() throws Exception {
        S3Client s3Client = null;
        try {
            admin.info("AWS S3 Configuration Start");
            s3Client = S3Client.builder()
                    .credentialsProvider(new GajulaAwsCredentialsProvider())
                    .region(Region.US_EAST_1)
                    .build();
            admin.info("AWS S3 Configuration End");
        } catch (Exception e) {
            admin.error("AWS S3 Configuration error " + e.getMessage());
        }
        return s3Client;
    }

}
