package com.zero.utils;

import java.util.UUID;

/**
 * @author LiFengHao
 **/
public class UUidUtils {

    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getSerialNo() {
        return getUuid() + System.currentTimeMillis();
    }

}
