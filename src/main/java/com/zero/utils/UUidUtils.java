package com.zero.utils;

import java.util.UUID;

/**
 * @author LiFengHao
 * @description
 * @date 2023/12/16 18:05
 **/
public class UUidUtils {
    public static String random() {
        // 生成随机的UUID
        UUID uuid = UUID.randomUUID();
        // 将UUID转换成字符串并去掉其中的"-"符号
        String rawInviteCode = uuid.toString().replace("-", "");
        // 截取字符串的前12个字符作为邀请码
        return rawInviteCode.substring(0, 12);
    }

}
