package com.example.analysis.dao.params;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description 数据传参
 * @Author snq
 * @Date 2022/6/5 15:20
 */
public class UserPartInput {

    @ApiModelProperty(value = "用户信息（前端传）")
    private String userInfo;

    @ApiModelProperty(value = "配件信息（前端传）")
    private String partInfo;

}
