package com.example.analysis.controller;

import com.example.analysis.dao.params.UserPartInput;
import com.example.analysis.service.IPartAnalysisService;
import com.example.support.PageResult;
import com.example.support.Result;
import com.example.support.enums.BizErrorCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description 配件解析控制器
 * @Author snq
 */
@RestController
@CrossOrigin
@RequestMapping("/api/part")
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
