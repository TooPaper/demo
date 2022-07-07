package com.example.analysis.dao.params;

import com.example.support.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 杆样式颜色类型 传参对象
 * </p>
 *
 * @author demo
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="PoleTypeParam", description="杆样式颜色类型传参对象")
public class PoleTypeParam extends PageParam {

}