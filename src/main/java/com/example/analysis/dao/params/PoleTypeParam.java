package com.example.analysis.dao.params;

import com.example.support.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: demo
 * @Date: 2022-07-07T13:32:06.361
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="PoleTypeParam", description="杆样式颜色类型传参对象")
public class PoleTypeParam extends PageParam {

}