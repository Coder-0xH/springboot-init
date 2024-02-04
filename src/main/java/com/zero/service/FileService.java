package com.zero.service;

import com.zero.model.vo.BaseFileService;
import com.zero.model.vo.FileOperResult;
import com.zero.model.vo.ObjectSummary;

import java.io.InputStream;
import java.util.List;

/**
 * @description 文件操作
 */
public interface FileService extends BaseFileService {
    /**
     * @param filePath    文件路径
     * @param inputStream 文件流
     */
    FileOperResult upload(String filePath, InputStream inputStream);

    /**
     * @param objectName 文件地址
     * @return java.lang.String
     */
    String generatePresignedUrl(String objectName);

    /**
     * @param maxKeys 最大KEy
     * @return java.util.List<com.sgcc.entity.ObjectSummary>
     * @description: 获取obj列表
     */
    List<ObjectSummary> listObjects(Integer maxKeys);

    /**
     * @param filePath 文件URL
     * @description: 删除文件
     */
    void deleteObject(String filePath);

    /**
     * @param filePath 文件地址
     * @return java.io.InputStream
     * @description: 获取文件流
     */
    InputStream getObject(String filePath);

    /**
     * @return java.lang.String
     * @description: 获取默认URL前缀
     */
    String getUrlPrefix();

}
