package me.fanbin.bubble.common.core.util;

import lombok.*;
import lombok.experimental.Accessors;
import me.fanbin.bubble.common.core.constant.CommonConstants;

import java.io.Serializable;

/**
 * 响应资源主体
 * @author fanbin
 * @date 2021/4/20
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    @Getter
    @Setter
    private int code;

    /**
     * 状态信息
     */
    @Getter
    @Setter
    private String msg;

    /**
     * 响应数据
     */
    @Getter
    @Setter
    private T data;

    public static <T> R<T> ok() {
        return restResult(CommonConstants.STATUS_SUCCESS, null, null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(CommonConstants.STATUS_SUCCESS, null, data);
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(CommonConstants.STATUS_SUCCESS, msg, data);
    }

    public static <T> R<T> fail() {
        return restResult(CommonConstants.STATUS_FAIL, null, null);
    }

    public static <T> R<T> fail(String msg) {
        return restResult(CommonConstants.STATUS_FAIL, msg, null);
    }

    private static <T> R<T> restResult(int code, String msg, T data) {
        return new R<>(code, msg, data);
    }

}
