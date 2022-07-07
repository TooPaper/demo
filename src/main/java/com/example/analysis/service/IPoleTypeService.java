package com.example.analysis.service;

import com.example.analysis.dao.params.PoleTypeParam;
import com.example.analysis.dao.vo.PoleTypeVo;
import com.example.support.PageResult;

import java.util.List;

import com.example.analysis.entity.PoleType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 杆样式颜色类型 服务类
 * </p>
 *
 * @author demo
 * @since 2022-07-07
 */
public interface IPoleTypeService extends IService<PoleType> {

	/**
	 * 杆样式颜色类型分页
	 */
	PageResult<PoleTypeVo> pagePoleTypeVo(PoleTypeParam param);
	/**
	 * 杆样式颜色类型详情
	 */
	PoleTypeVo viewPoleTypeVo(Long id);

	/**
	 * 杆样式颜色类型编辑
	 */
	Integer editPoleTypeVo(PoleTypeVo vo);

	/**
	 * 杆样式颜色类型新增
	 */
	PoleTypeVo addPoleTypeVo(PoleTypeVo vo);

	/**
	 * 杆样式颜色类型删除
	 */
	Integer removePoleTypeVos(List<Long> ids);


}
