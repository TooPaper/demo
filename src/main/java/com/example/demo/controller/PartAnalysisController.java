package com.example.demo.controller;

import com.example.demo.enums.BizErrorCodeEnum;
import com.example.demo.input.UserPartInput;
import com.example.demo.result.Result;
import com.example.demo.service.IPartAnalysisService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * @Description 配件解析控制器
 * @Author snq
 * @Date 2022/6/5 14:31
 */
@RestController
@RequestMapping("/part")
@Api(value ="配件解析", tags = "配件解析")
public class PartAnalysisController {

    public final static Logger logger = LoggerFactory.getLogger(PartAnalysisController.class);

    @Autowired
	IPartAnalysisService partAnalysisService;

    @PostMapping(value ="/get-file", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "获取文件", notes = "获取文件")
    public Result<Map<String, String>> getFundInformation(@RequestBody @ApiParam(name = "传入json格式",
			value = "参数：userInfo, partInfo", required = true) UserPartInput input){
		try {
			return Result.success(partAnalysisService.getPartsByPartInfo(input));
		} catch (Exception e) {
			logger.error("查询公募基金基本信息失败", e);
            return Result.error(BizErrorCodeEnum.BIZ_UNKNOWN_EXCEPTION);
		}
	}

}
