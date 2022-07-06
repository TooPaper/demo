DROP TABLE `pole_type`
CREATE TABLE `pole_type` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `type_code` bigint NOT NULL COMMENT '类型编号',
    `parent_type_code` bigint COMMENT '父类类型编号',
    `type_name` varchar(30) NOT NULL COMMENT '类型名称',
    `create_user` varchar(30) NOT NULL COMMENT '创建人',
    `create_date` datetime NOT NULL COMMENT '创建时间',
    `update_user` varchar(30) NOT NULL COMMENT '更新人',
    `update_date` datetime NOT NULL COMMENT '更新时间',
    `state` int NOT NULL COMMENT '是否有效 0-无效 1-有效',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COMMENT='杆样式颜色类型';
INSERT INTO `pole_type`(`type_code`, `parent_type_code`, `type_name`, , `create_user`, `create_date`, `update_user`, `update_date`, `state`)
VALUES (1, null, '八角杆', 1, NOW(), 1, NOW(), 1);
