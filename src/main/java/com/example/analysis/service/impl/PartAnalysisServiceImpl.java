package com.example.analysis.service.impl;

import com.example.analysis.dao.params.UserPartInput;
import com.example.analysis.service.IPartAnalysisService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 配件业务层
 * @Author snq
 * @Date 2022/6/5 15:32
 */
@Service
public class PartAnalysisServiceImpl implements IPartAnalysisService {

    @Override
    public Map<String, String> getPartsByPartInfo(UserPartInput input) {
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "bbb");
        return map;
    }

}
