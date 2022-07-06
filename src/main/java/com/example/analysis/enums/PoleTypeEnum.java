package com.example.analysis.enums;

import com.example.support.ISystemCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 杆-类型
 * @Author snq
 * @Date 2022/6/5 14:39
 */
@Getter
@AllArgsConstructor
public enum PoleTypeEnum implements ISystemCode {

    /**
     * 杆-类型
     */
    POLE_OCTAGON_TYPE(1, "八角杆"),
    POLE_FRESH_TYPE(2, "小清新"),
    POLE_PLUM_TYPE(3, "梅花");

    private final int code;

    private final String description;

}
