package com.zero.utils.file;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

/**
 * @description 文件格式转换工具类
 */
public class FileConvertUtil {

    /**
     * 方法描述 office文档转换为PDF(处理本地文件)
     *
     * @param sourcePath 源文件路径
     * @return InputStream 转换后文件输入流
     */
    public static InputStream convertLocaleFile(String sourcePath) throws Exception {
        File inputFile = new File(sourcePath);
        return  Files.newInputStream(inputFile.toPath());
    }

    /**
     * 方法描述  office文档转换为PDF(处理网络文件)
     *
     * @param netFileUrl 网络文件路径
     * @return InputStream 转换后文件输入流
     */
    public static InputStream convertNetFile(String netFileUrl) throws Exception {
        // 创建URL
        URL url = new URL(netFileUrl);
        // 试图连接并取得返回状态码
        URLConnection urlConn = url.openConnection();
        urlConn.connect();
        HttpURLConnection httpConn = (HttpURLConnection) urlConn;
        int httpResult = httpConn.getResponseCode();
        if (httpResult == HttpURLConnection.HTTP_OK) {
            return urlConn.getInputStream();
        }
        return null;
    }

    /**
     * 方法描述 outputStream转inputStream
     */
    public static ByteArrayInputStream outputStreamConvertInputStream(final OutputStream out) throws Exception {
        ByteArrayOutputStream baos = (ByteArrayOutputStream) out;
        return new ByteArrayInputStream(baos.toByteArray());
    }
}
