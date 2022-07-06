package com.example.analysis.service;

import com.example.analysis.dao.params.PoleTypeParam;
import com.example.analysis.dao.vo.PoleTypeVo;
import com.example.support.PageResult;

import com.example.analysis.entity.PoleType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 杆样式颜色类型 服务类
 * </p>
 *
 * @author demo
 * @since 2022-07-06
 */
public interface IPoleTypeService extends IService<PoleType> {

	/**
	 * 杆样式颜色类型分页
	 */
	PageResult<PoleTypeVo> pagePoleTypeVo(PoleTypeParam param);

}
