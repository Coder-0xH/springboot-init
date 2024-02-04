package com.zero.model.vo;

import lombok.SneakyThrows;

import javax.servlet.http.HttpServletResponse;

/**
 * @author nqs
 * @project: px-account-cloud-dev
 * @package: com.sgcc.service
 * @description 公共实现
 * @date 2023/12/5 14:37
 */
public interface BaseFileService {
    /**
     * 生成路径以及文件名
     *
     * @param urlPrefix URL前缀
     * @param ownerType 业务对象类型
     * @param fileName  文件名
     */
    String getFilePath(String urlPrefix, String ownerType, String fileName);

    String setUrlPrefix(String urlPrefix);

    HttpServletResponse getHttpServletResponse();

    @SneakyThrows
    void previewOutputStream(String url);
}
