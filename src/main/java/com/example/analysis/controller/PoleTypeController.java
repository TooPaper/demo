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

import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 杆样式颜色类型 前端控制器
 * </p>
 *
 * @author demo
 * @since 2022-07-07
 */
@RestController
@RequestMapping("/poleType")
@Api(value ="杆样式颜色类型", tags = "杆样式颜色类型管理")
public class PoleTypeController {

	public final static Logger logger = LoggerFactory.getLogger(PoleTypeController.class);

	@Autowired
	IPoleTypeService  poleTypeService;

	@PostMapping(value ="/page", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "杆样式颜色类型分页", notes = "分页杆样式颜色类型")
	public Result<PageResult<PoleTypeVo>> pagePoleTypeVo(@RequestBody @ApiParam(name = "传入json格式",
			value = "参数：", required = true) PoleTypeParam param) {
		try {
			return Result.success(poleTypeService.pagePoleTypeVo(param));
		} catch (Exception e) {
			logger.error("分页杆样式颜色类型失败", e);
			return Result.error(BizErrorCodeEnum.BIZ_UNKNOWN_EXCEPTION);
		}
	}

	@GetMapping(value ="/view/{id}")
	@ApiOperation(value = "杆样式颜色类型详情", notes = "详情杆样式颜色类型")
	public Result<PoleTypeVo> viewPoleTypeVo(@PathVariable Long id) {
		try {
			return Result.success(poleTypeService.viewPoleTypeVo(id));
		} catch (Exception e) {
			logger.error("详情杆样式颜色类型失败", e);
			return Result.error(BizErrorCodeEnum.BIZ_UNKNOWN_EXCEPTION);
		}
	}

	@PostMapping(value ="/edit", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "杆样式颜色类型编辑", notes = "编辑杆样式颜色类型")
	public Result<Integer> editPoleTypeVo(@RequestBody @ApiParam(name = "传入json格式",
			value = "参数：", required = true) PoleTypeVo vo) {
		try {
			return Result.success(poleTypeService.editPoleTypeVo(vo));
		} catch (Exception e) {
			logger.error("编辑杆样式颜色类型失败", e);
			return Result.error(BizErrorCodeEnum.BIZ_UNKNOWN_EXCEPTION);
		}
	}

	@PostMapping(value ="/add", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "杆样式颜色类型新增", notes = "新增杆样式颜色类型")
	public Result<PoleTypeVo> addPoleTypeVo(@RequestBody @ApiParam(name = "传入json格式",
			value = "参数：", required = true) PoleTypeVo vo) {
		try {
			return Result.success(poleTypeService.addPoleTypeVo(vo));
		} catch (Exception e) {
			logger.error("新增杆样式颜色类型失败", e);
			return Result.error(BizErrorCodeEnum.BIZ_UNKNOWN_EXCEPTION);
		}
	}

	@GetMapping(value ="/remove/{ids}", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "杆样式颜色类型删除", notes = "删除杆样式颜色类型")
	@ApiImplicitParam(name = "ids", value = "ids", required = true, dataType = "Long", allowMultiple = true, example = "0", paramType = "path")
	public Result<Integer> removePoleTypeVos(@PathVariable Long[] ids) {
		try {
			return Result.success(poleTypeService.removePoleTypeVos(Arrays.asList(ids)));
		} catch (Exception e) {
			logger.error("删除杆样式颜色类型失败", e);
			return Result.error(BizErrorCodeEnum.BIZ_UNKNOWN_EXCEPTION);
		}
	}


}
