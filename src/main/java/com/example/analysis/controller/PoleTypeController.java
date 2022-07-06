package com.example.analysis.controller;

import com.example.analysis.dao.params.PoleTypeParam;
import com.example.analysis.service.IPoleTypeService;
import com.example.analysis.dao.vo.PoleTypeVo;
import com.example.support.PageResult;
import com.example.support.Result;
import com.example.support.enums.BizErrorCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 杆样式颜色类型 前端控制器
 * </p>
 *
 * @author demo
 * @since 2022-07-06
 */
@RestController
@RequestMapping("/poleType")
@Api(value ="杆样式颜色类型", tags = "杆样式颜色类型管理")
public class PoleTypeController {

	public final static Logger logger = LoggerFactory.getLogger(PoleTypeController.class);

	@Autowired
	IPoleTypeService  poleTypeService;

	@PostMapping(value ="/page", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "分页杆样式颜色类型", notes = "分页杆样式颜色类型")
	public Result<PageResult<PoleTypeVo>> pagePoleType(@RequestBody @ApiParam(name = "传入json格式",
			value = "参数：", required = true) PoleTypeParam param){
		try {
			return Result.success(poleTypeService.pagePoleTypeVo(param));
		} catch (Exception e) {
			logger.error("分页杆样式颜色类型失败", e);
			return Result.error(BizErrorCodeEnum.BIZ_UNKNOWN_EXCEPTION);
		}
	}


}
