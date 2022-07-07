package com.example.analysis.dao.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 * 杆样式颜色类型 Vo对象
 * </p>
 *
 * @author demo
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode()
@ApiModel(value="PoleTypeVo", description="杆样式颜色类型Vo对象")
public class PoleTypeVo {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "类型编号")
    private String typeCode;

    @ApiModelProperty(value = "父类类型编号")
    private String parentTypeCode;

    @ApiModelProperty(value = "类型名称")
    private String typeName;

    @ApiModelProperty(value = "创建人")
    private Long createUser;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新人")
    private Long updateUser;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;

    @ApiModelProperty(value = "是否有效 0-无效 1-有效")
    private Integer state;

}