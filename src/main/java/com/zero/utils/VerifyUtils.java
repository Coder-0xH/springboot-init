package com.zero.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sonata
 */
@Slf4j
public class VerifyUtils {

    /**
     * 手机号校验
     */
    private static final Pattern IS_MOBILE = Pattern.compile("^1[3-9]\\d{9}$");
    /**
     * 验证字符串是否由数字组成
     */
    private static final Pattern IS_NUMBER = Pattern.compile("[0-9]*");

    /**
     * 验证手机号
     *
     * @param mobile 手机号
     * @return boolean
     */
    public static boolean isMobile(String mobile) {
        Matcher m = IS_MOBILE.matcher(mobile);
        return m.matches();
    }

    /**
     * 验证字符串是否由数字组成
     *
     * @param str
     * @return
     */
    public static Boolean isNumber(String str) {
        if (str != null && !("").equals(str)) {
            Matcher matcher = IS_NUMBER.matcher(str);
            return matcher.matches();
        } else {
            return false;
        }
    }

    /**
     * 注册用户名验证
     * 必须以字母开头
     * 只能包括 字母 , 下划线 , 数字
     * 长度必须在6 到 16 之间
     */
    public static boolean checkUsername(String username) {
        //String regex="[a-zA-Z][0-9a-zA-Z_]{5,9}";
        //String regex="[a-zA-Z][\\da-zA-Z_]{5,9}";// \d  要转成 \\d
        String regex = "[a-zA-Z]\\w{5,10}";
        return username.matches(regex);
    }

    /**
     * 数字+字母组成，长度6-16位
     *
     * @param password 密码
     * @return 校验结果
     */
    public static boolean checkPassWord(String password) {
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
        return password.matches(regex);
    }

    /**
     * 判断身份证号码
     *
     * @param IDNumber
     * @return
     */
    public static boolean isIDNumber(String IDNumber) {
        if (IDNumber == null || "".equals(IDNumber)) {
            return false;
        }
        // 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）
        String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        //假设18位身份证号码:41000119910101123X  410001 19910101 123X
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //(18|19|20)                19（现阶段可能取值范围18xx-20xx年）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十七位奇数代表男，偶数代表女）
        //[0-9Xx] 0123456789Xx其中的一个 X（第十八位为校验值）
        //$结尾

        //假设15位身份证号码:410001910101123  410001 910101 123
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十五位奇数代表男，偶数代表女），15位身份证不含X
        //$结尾

        boolean matches = IDNumber.matches(regularExpression);
        //判断第18位校验值
        if (matches) {

            if (IDNumber.length() == 18) {
                try {
                    char[] charArray = IDNumber.toCharArray();
                    //前十七位加权因子
                    int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                    //这是除以11后，可能产生的11位余数对应的验证码
                    String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                    int sum = 0;
                    for (int i = 0; i < idCardWi.length; i++) {
                        int current = Integer.parseInt(String.valueOf(charArray[i]));
                        int count = current * idCardWi[i];
                        sum += count;
                    }
                    char idCardLast = charArray[17];
                    int idCardMod = sum % 11;
                    return idCardY[idCardMod].equalsIgnoreCase(String.valueOf(idCardLast));

                } catch (Exception e) {
                    log.error("ERROR:",e);
                    return false;
                }
            }

        }
        return matches;
    }
}
