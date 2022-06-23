/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.fanbin.bubble.common.core.constant;

/**
 * @author fanbin
 * @date 2022/6/23
 */
public class Regex {

    /**
     * 强密码
     */
    public static final String STRONG_PASSWORD = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";

    /**
     * 手机号
     */
    public static final String MOBILE_PHONE = "^((13[0-9])|(15[^4,\\D])|(14[57])|(17[0])|(17[7])|(18[0,0-9]))\\d{8}$";

    /**
     * 用户名
     */
    public static final String USERNAME = "^[a-zA-Z]\\w{5,17}$";

    /**
     * 身份证号
     */
    public static final String ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * 电子邮箱
     */
    public static final String EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 汉字
     */
    public static final String CHINESE = "^[\u4e00-\u9fa5],{0,}$";

    /**
     * URL地址
     */
    public static final String URL = "^[\u4e00-\u9fa5],{0,}$";

    /**
     * IP 地址
     */
    public static final String IP_ADDRESS = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

}
