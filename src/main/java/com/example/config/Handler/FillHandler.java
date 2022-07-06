package com.example.config.Handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author demo
 * @Data 2021/8/23
 */
@Slf4j
@Component
public class FillHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createUser", Long.class, 1L);
        this.strictInsertFill(metaObject, "createUsername", String.class, "demo");
        this.strictInsertFill(metaObject, "createDate", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "states", String.class,"1");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateUser", 1L, metaObject);
        this.setFieldValByName("updateDate", LocalDateTime.now(), metaObject);
    }

}
