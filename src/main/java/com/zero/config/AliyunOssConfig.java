package com.zero.config;

import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import com.zero.config.proterties.AliyunOssProperties;
import com.zero.service.FileService;
import com.zero.service.impl.OssFileServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;


/**
 * @author sonata
 * @description: 阿里oss配置
 * 如果使用阿里云做文件服务自动配置
 */
@Configuration
@EnableConfigurationProperties(AliyunOssProperties.class)
@ConditionalOnProperty(name = "aliyun.oss.accessKeyId", matchIfMissing = false)
public class AliyunOssConfig {
    @Resource
    private AliyunOssProperties aliyunOssProperties;

    @Bean
    public FileService ossConfig() {
        ClientBuilderConfiguration clientConfiguration = new ClientBuilderConfiguration();
        clientConfiguration.setConnectionTimeout(5 * 1000);
        clientConfiguration.setSocketTimeout(10 * 1000);
        OSS oss = new OSSClientBuilder().build(aliyunOssProperties.getEndpoint(), aliyunOssProperties.getAccessKeyId(), aliyunOssProperties.getAccessKeySecret(), clientConfiguration);
        return new OssFileServiceImpl(oss, aliyunOssProperties);
    }
}
