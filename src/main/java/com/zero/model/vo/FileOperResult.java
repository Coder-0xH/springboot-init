package com.zero.model.vo;

import lombok.Data;

@Data
public class FileOperResult {
    public FileOperResult() {

    }

    public FileOperResult(String fileName) {
        this.fileName = fileName;
    }

    //文件ID
    private String id;

    // 文件原名
    private String fileName;

    // 文件存储路径
    private String filePath;

    // 状态有：error failed success
    private String status;

    private Boolean isSuccess;

    //上传文件返回消息
    private String message;

    //上传状态
    private String etag;


    //url访问地址
    private String fileUrl;
}
