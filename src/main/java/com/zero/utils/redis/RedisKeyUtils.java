package com.zero.utils.redis;


import com.zero.utils.enums.RedisKey;

public class RedisKeyUtils {
    /**
     * 下划线
     */
    private static final char SEPARATOR = '_';
    /**
     * redis缓存Key统一前缀，必须以此为前缀
     */
    private static final String KEY_PREFIX = "SONATA:ACCOUNT";

    /**
     * @param accountId 用户ID
     * @return java.lang.String
     * @description: 获取当前登录账户
     * @author sonata
     */
    public static String getAccountInfoKey(String accountId) {
        return String.format("%s:%s:%s", KEY_PREFIX, RedisKey.ACCOUNT_INFO.getValue(), accountId);
    }

}
