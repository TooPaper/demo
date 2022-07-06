package com.example.support;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @Author demo
 */
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@ApiModel(value="PageParam", description="分页查询对象")
public class PageParam {

    @ApiModelProperty(value = "页码")
    private Long pageIndex;

    @ApiModelProperty(value = "每页数量")
    private Long pageSize;

    public PageParam(){
        this.setPageIndex(1L);
        this.setPageSize(10L);
    }

}
