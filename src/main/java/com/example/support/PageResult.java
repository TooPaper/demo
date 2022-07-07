//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.support;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

/**
 * <p>
 * 分页结果集
 * </p>
 *
 * @author init
 * @since 2022-07-07
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("分页结果")
public class PageResult<T> {

    @ApiModelProperty("页码")
    private Long pageIndex;

    @ApiModelProperty("每页数量")
    private Long pageSize;

    @ApiModelProperty("总记录数")
    private Long total;

    @ApiModelProperty(value = "总页数")
    private long totalPage;

    @ApiModelProperty("记录")
    private List<T> records;

    @ApiModelProperty("排序")
    private List<OrderItem> orders;

    public PageResult(AppPage<T> appPage){
        this.pageIndex = appPage.getCurrent();
        this.pageSize = appPage.getSize();
        this.total = appPage.getTotal();
        this.totalPage = appPage.getPages();
        this.records = appPage.getRecords();
        this.orders = appPage.getOrders();
    }

}
