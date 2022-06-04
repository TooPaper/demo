package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述: 基金公告类型
 *
 * @author www
 * @date 2022/5/25 14:18
 */

@Getter
@AllArgsConstructor
public enum MfAnnouncementCategoryEnum {

    /**
     * 公募基金公告原文类型：【jydb.MF_Announcement.Category】
     */
    ANNOUNCEMENT_TYPE_ENUM_0("全部", Arrays.asList(4, 5, 6, 10, 17, 19, 20, 21, 23, 50, 52, 61, 63, 65, 67, 104, 121, 123, 130, 137, 141, 142)),
    ANNOUNCEMENT_TYPE_ENUM_1("发行公告", Arrays.asList(21, 19, 137, 130)),
    ANNOUNCEMENT_TYPE_ENUM_2("定期报告", Arrays.asList(61, 23, 63, 17, 5, 67, 6, 65)),
    ANNOUNCEMENT_TYPE_ENUM_3("业务公告", Arrays.asList(20, 104, 4, 10)),
    ANNOUNCEMENT_TYPE_ENUM_4("其他公告", Arrays.asList(141, 142, 50, 121, 52, 123));

    private final String categoryName;
    private final List<Integer> categories;

    /**
     * 根据 类型编号 获取 类型名称
     * @param category 类型编号
     * @return 类型名称
     */
    public static String getCategoryName(Integer category) {
        for (MfAnnouncementCategoryEnum warningEnum : MfAnnouncementCategoryEnum.values()) {
            if (!"全部".equals(warningEnum.categoryName) && warningEnum.categories.contains(category)) {
                return warningEnum.categoryName;
            }
        }
        return null;
    }

    /**
     * 获取 所有类型
     * @return 类型名称 集合
     */
    public static List<String> getCategoryNames() {
        List<String> categoryNames = new ArrayList<>();
        for (MfAnnouncementCategoryEnum warningEnum : MfAnnouncementCategoryEnum.values()) {
            categoryNames.add(warningEnum.categoryName);
        }
        return categoryNames;
    }

}
