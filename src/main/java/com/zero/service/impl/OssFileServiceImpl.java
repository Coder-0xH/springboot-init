package com.zero.service.impl;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSS;
import com.aliyun.oss.model.*;
import com.zero.config.proterties.AliyunOssProperties;
import com.zero.model.vo.BaseFileServiceImpl;
import com.zero.model.vo.FileOperResult;
import com.zero.model.vo.ObjectSummary;
import com.zero.service.FileService;

import lombok.SneakyThrows;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;

import java.net.URL;
import java.net.URLEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description 阿里云oss实现
 */
public class OssFileServiceImpl extends BaseFileServiceImpl implements FileService {
    OSS client;
    AliyunOssProperties properties;

    public OssFileServiceImpl(OSS oss, AliyunOssProperties aliyunOssProperties) {
        client = oss;
        properties = aliyunOssProperties;
    }

    /**
     * @param filePath 文件地址
     * @return java.lang.String
     * @description: 生成URL访问地址
     * @author nqs
     * @date 2023/12/5 15:04
     */
    private String generateUrl(String filePath) {
        if (StringUtils.isEmpty(properties.getCdnHost())) {
//            return String.format("https://%s.%s/%s", properties.getBucketName(), properties.getEndpoint(), filePath);
            return filePath;
        } else {
            return String.format("%s%s", properties.getCdnHost(), filePath);
        }
    }

    /**
     * @param filePath    文件路径
     * @param inputStream 文件流
     * @return com.sgcc.entity.FileOperResult
     * @description: oss文件上传
     * @author nqs
     * @date 2023/12/4 19:49
     */
    @Override
    public FileOperResult upload(String filePath, InputStream inputStream) {
        PutObjectResult result = client.putObject(properties.getBucketName(), filePath, inputStream);
        FileOperResult fileOperResult = new FileOperResult();
        //url访问地址
        fileOperResult.setFilePath(generateUrl(filePath));
        return fileOperResult;
    }


    /**
     * @param objectName 文件地址
     * @return java.lang.String
     * @description: 生成签名URL
     * @author nqs
     * @date 2023/12/5 14:55
     */
    @SneakyThrows
    @Override
    public String generatePresignedUrl(String objectName) {
        //判断当前文件服务是否有配置CDN或者域名
        //如果有直接返回url
        if (!StringUtils.isEmpty(properties.getCdnHost())) {
            return generateUrl(objectName);
        }
        // 设置签名URL过期时间，单位为毫秒。 设置为10分钟
        Date expiration = new Date(new Date().getTime() + 600 * 1000L);
        URL url = client.generatePresignedUrl(properties.getBucketName(), objectName, expiration, HttpMethod.GET);
        if (StringUtils.isEmpty(properties.getHost())) {
            return String.valueOf(url);
        }
        return properties.getHost() + "/file/preview?id=" + URLEncoder.encode(String.valueOf(url), "utf-8");
    }

    /**
     * @param maxKeys 最大KEy
     * @return java.util.List<com.sgcc.entity.ObjectSummary>
     * @description: 获取obj列表
     * @author nqs
     * @date 2023/12/5 14:54
     */
    @Override
    public List<ObjectSummary> listObjects(Integer maxKeys) {
        ListObjectsRequest lor = new ListObjectsRequest(properties.getBucketName()).withMaxKeys(maxKeys);
        ObjectListing objectListing = client.listObjects(lor);
        List<OSSObjectSummary> objectSummaries = objectListing.getObjectSummaries();
        if (CollectionUtils.isEmpty(objectSummaries)) {
            return new ArrayList<>();
        }
        return objectSummaries.stream().map(l -> {
            ObjectSummary objectSummary = new ObjectSummary();
            BeanUtils.copyProperties(l, objectSummary);
            return objectSummary;
        }).collect(Collectors.toList());
    }

    /**
     * @param filePath 文件URL
     * @description: 删除文件
     * @author nqs
     * @date 2023/12/5 15:07
     */
    @Override
    public void deleteObject(String filePath) {
        client.deleteObject(properties.getBucketName(), filePath);
    }

    /**
     * @param filePath 文件地址
     * @return java.io.InputStream
     * @description: 获取文件流
     * @author nqs
     * @date 2023/12/5 15:18
     */
    @Override
    public InputStream getObject(String filePath) {
        OSSObject ossObject = client.getObject(properties.getBucketName(), filePath);
        return ossObject.getObjectContent();
    }

    @Override
    public String getUrlPrefix() {
        return this.setUrlPrefix(properties.getUrlPrefix());
    }

}
