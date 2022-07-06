package com.example.analysis.dao.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Description TODO
 * @Author snq
 * @Date 2022/4/28 16:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pole {

    @ApiModelProperty(value = "ID")
    private int id;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "米数")
    private double meters;

    @ApiModelProperty(value = "标签ID")
    private String email;

    @ApiModelProperty(value = "标签ID")
    private LocalDateTime birthday;


}