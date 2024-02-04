package com.zero.config.proterties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author sonata
 * @description 阿里云OSS配置
 */
@Data
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOssProperties {
    /**
     * endpoint
     */
    private String endpoint;
    /**
     * accessKeyId
     */
    private String accessKeyId;

    /**
     * accessKeySecret
     */
    private String accessKeySecret;
    /**
     * bucketName
     */
    private String bucketName;

    /**
     * 上传前缀
     */
    private String urlPrefix;
    /**
     * -
     * 回调地址
     */
    private String callbackUrl;

    /**
     * -
     * cdnHost
     */
    private String cdnHost;

    /**
     * 文件查看host
     */
    private String host;
}
