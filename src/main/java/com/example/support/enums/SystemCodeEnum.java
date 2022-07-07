package com.example.support.enums;

import com.example.support.ISystemCode;

/**
 * <p>
 * 状态码
 * </p>
 *
 * @author init
 * @since 2022-07-07
 */
public enum SystemCodeEnum implements ISystemCode {

    /**
     * 状态码
     */
    SUCCESS(200, "成功"),
    BAD_REQUEST(400, "成功"),
    UNCAUGHT_EXCEPTION(500, "系统异常");

    private final int code;
    private final String description;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    SystemCodeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

}