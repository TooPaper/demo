package com.example.support.enums;

import com.example.support.ISystemCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 错误提示
 * </p>
 *
 * @author demo
 * @since 2022-07-07
 */
@Getter
@AllArgsConstructor
public enum BizErrorCodeEnum implements ISystemCode {

    /**
     * 返回异常提示
     */
    BIZ_UNKNOWN_EXCEPTION(10100, "系统异常！");

    private final int code;

    private final String description;

}
