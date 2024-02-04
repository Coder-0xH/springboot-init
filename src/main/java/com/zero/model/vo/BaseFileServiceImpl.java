package com.zero.model.vo;


import com.zero.utils.file.FileConvertUtil;
import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @description 公共实现
 */
public class BaseFileServiceImpl implements BaseFileService {

    /**
     * 生成路径以及文件名
     *
     * @param ownerType 业务对象类型
     * @param fileName  文件名
     */
    @Override
    public String getFilePath(String urlPrefix, String ownerType, String fileName) {
        LocalDate now = LocalDate.now();
        return urlPrefix + ownerType + "/" + now.getYear() + "/" +
                now.getMonth().getValue() + "/" + now.getDayOfMonth() + "/" +
                System.currentTimeMillis() + RandomUtils.nextInt(1000000, 9999999) +
                "." + StringUtils.substringAfterLast(fileName, ".");
    }

    @Override
    public String setUrlPrefix(String urlPrefix) {
        if (StringUtils.isBlank(urlPrefix)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (urlPrefix.startsWith("/")) {
            stringBuilder.append(urlPrefix.substring(1));
        } else {
            stringBuilder.append(urlPrefix);
        }

        if (!urlPrefix.endsWith("/")) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    /**
     * @return javax.servlet.http.HttpServletResponse
     * @description: 获取HttpServletResponse
     * @author nqs
     * @date 2024/1/26 14:38
     */
    @Override
    public HttpServletResponse getHttpServletResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return Objects.requireNonNull(requestAttributes).getResponse();
    }

    /**
     * @param url url 文件地址
     * @description: 文件预览输出流
     * @author nqs
     * @date 2024/1/26 14:46
     */
    @SneakyThrows
    public void previewOutputStream(String url) {
        InputStream in = FileConvertUtil.convertNetFile(url);
        OutputStream outputStream = getHttpServletResponse().getOutputStream();
        //创建存放文件内容的数组
        byte[] buff = new byte[1024];
        //所读取的内容使用n来接收
        int n;
        //当没有读取完时,继续读取,循环
        while ((n = Objects.requireNonNull(in).read(buff)) != -1) {
            //将字节数组的数据全部写入到输出流中
            outputStream.write(buff, 0, n);
        }
        //强制将缓存区的数据进行输出
        outputStream.flush();
        //关流
        outputStream.close();
        in.close();
    }
}
