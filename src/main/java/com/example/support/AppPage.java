package com.example.support;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * <p>
 * 分页工具
 * </p>
 *
 * @author init
 * @since 2022-07-07
 */
public class AppPage<T> implements IPage<T> {

    protected List<T> list;
    protected long total;
    protected long pageSize;
    protected long current;
    protected List<OrderItem> orders;
    protected boolean optimizeCountSql;
    protected boolean isSearchCount;
    protected boolean hitCount;
    protected String countId;
    protected Long maxLimit;

    public AppPage() {
        this.list = Collections.emptyList();
        this.total = 0L;
        this.pageSize = 10L;
        this.current = 1L;
        this.orders = new ArrayList<>();
        this.optimizeCountSql = true;
        this.isSearchCount = true;
        this.hitCount = false;
    }

    public AppPage(PageParam pageParam){
        this(pageParam.getPageIndex(),pageParam.getPageSize());
    }

    public AppPage(long current, long pageSize) {
        this(current, pageSize, 0L);
    }

    public AppPage(long current, long pageSize, long total) {
        this(current, pageSize, total, true);
    }

    public AppPage(long current, long pageSize, boolean isSearchCount) {
        this(current, pageSize, 0L, isSearchCount);
    }

    public AppPage(long current, long pageSize, long total, boolean isSearchCount) {
        this.list = Collections.emptyList();
        this.total = 0L;
        this.pageSize = 10L;
        this.current = 1L;
        this.orders = new ArrayList<>();
        this.optimizeCountSql = true;
        this.isSearchCount = true;
        this.hitCount = false;
        if (current > 1L) {
            this.current = current;
        }

        this.pageSize = pageSize;
        this.total = total;
        this.isSearchCount = isSearchCount;
    }

    public boolean hasPrevious() {
        return this.current > 1L;
    }

    public boolean hasNext() {
        return this.current < this.getPages();
    }

    @Override
    public List<T> getRecords() {
        return this.list;
    }

    @Override
    public AppPage<T> setRecords(List<T> list) {
        this.list = list;
        return this;
    }

    @Override
    public long getTotal() {
        return this.total;
    }

    @Override
    public AppPage<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    @Override
    public long getSize() {
        return this.pageSize;
    }

    @Override
    public AppPage<T> setSize(long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public long getCurrent() {
        return this.current;
    }

    @Override
    public AppPage<T> setCurrent(long current) {
        this.current = current;
        return this;
    }

    @Override
    public String countId() {
        return this.getCountId();
    }

    @Override
    public Long maxLimit() {
        return this.getMaxLimit();
    }

    private String[] mapOrderToArray(Predicate<OrderItem> filter) {
        List<String> columns = new ArrayList<>(this.orders.size());
        this.orders.forEach((i) -> {
            if (filter.test(i)) {
                columns.add(i.getColumn());
            }

        });
        return columns.toArray(new String[0]);
    }

    private void removeOrder(Predicate<OrderItem> filter) {
        for(int i = this.orders.size() - 1; i >= 0; --i) {
            if (filter.test(this.orders.get(i))) {
                this.orders.remove(i);
            }
        }

    }

    public AppPage<T> addOrder(OrderItem... items) {
        this.orders.addAll(Arrays.asList(items));
        return this;
    }

    public AppPage<T> addOrder(List<OrderItem> items) {
        this.orders.addAll(items);
        return this;
    }

    @Override
    public List<OrderItem> orders() {
        return this.getOrders();
    }

    @Override
    public boolean optimizeCountSql() {
        return this.optimizeCountSql;
    }

    public boolean isOptimizeCountSql() {
        return this.optimizeCountSql();
    }

    @Override
    public boolean isSearchCount() {
        return this.total >= 0L && this.isSearchCount;
    }

    public AppPage<T> setSearchCount(boolean isSearchCount) {
        this.isSearchCount = isSearchCount;
        return this;
    }

    public AppPage<T> setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
        return this;
    }

    public void setHitCount(boolean hit) {
        this.hitCount = hit;
    }

    public List<OrderItem> getOrders() {
        return this.orders;
    }

    public void setOrders(final List<OrderItem> orders) {
        this.orders = orders;
    }

    public String getCountId() {
        return this.countId;
    }

    public void setCountId(final String countId) {
        this.countId = countId;
    }

    public Long getMaxLimit() {
        return this.maxLimit;
    }

    public void setMaxLimit(final Long maxLimit) {
        this.maxLimit = maxLimit;
    }
}
