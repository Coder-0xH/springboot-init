package com.zero.utils.enums;

import lombok.Getter;

@Getter
public enum RedisKey {
    /**
     * redisKey
     */
    ACCOUNT_INFO("获取当前登录账户KEY", "accountInfo", 1),
    ;

    private final String name;
    private final String value;
    /* hash求余数量 */
    private final int mapCount;


    RedisKey(String name, String value, int mapCount) {
        this.name = name;
        this.value = value;
        this.mapCount = mapCount;
    }
}
