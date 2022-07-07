package com.example.utils;

import java.util.List;

/**
 * <p>
 * 分页工具
 * </p>
 *
 * @author init
 * @since 2022-07-07
 */
public class PageUtil {

    /**
     * 开始分页 —— list.size() > (pageNum-1) * pageSize
     * @param list 分页集合
     * @param pageNum 页码
     * @param pageSize 每页多少条数据
     * @return 集合分页对象
     */
    public static <T> List<T> startPage(List<T> list, Integer pageNum, Integer pageSize) {

        if (list == null) {
            return null;
        }
        if (list.size() == 0) {
            return null;
        }

        // 记录总数
        Integer count = list.size();
        // 页数
        int pageCount = 0;
        if (count % pageSize == 0) {
            pageCount = count / pageSize;
        } else {
            pageCount = count / pageSize + 1;
        }

        // 开始索引
        int fromIndex = 0;
        // 结束索引
        int toIndex = 0;

        if (!pageNum.equals(pageCount)) {
            fromIndex = (pageNum - 1) * pageSize;
            toIndex = fromIndex + pageSize;
        } else {
            fromIndex = (pageNum - 1) * pageSize;
            toIndex = count;
        }

        return list.subList(fromIndex, toIndex);
    }
}
