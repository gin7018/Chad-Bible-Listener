package com.org.chad.module

import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class S3BucketModule {

    @Bean
    fun s3Client(): AmazonS3 {
        return AmazonS3ClientBuilder
            .standard()
            .withRegion(Regions.US_EAST_1)
            .build()
    }
}