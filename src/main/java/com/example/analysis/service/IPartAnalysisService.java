package com.example.analysis.service;

import com.example.analysis.dao.params.UserPartInput;

import java.util.Map;

/**
 * @Description 配件信息业务接口
 * @Author snq
 * @Date 2022/6/5 14:32
 */
public interface IPartAnalysisService {

    /**
     *
     */
    Map<String, String> getPartsByPartInfo(UserPartInput input);

}