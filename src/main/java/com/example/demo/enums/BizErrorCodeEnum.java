package com.example.demo.enums;

import com.example.demo.result.ISystemCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 错误提示
 * @Author snq
 * @Date 2022/6/5 14:39
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
