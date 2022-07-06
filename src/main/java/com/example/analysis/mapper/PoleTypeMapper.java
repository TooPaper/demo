package com.example.analysis.mapper;

import com.example.analysis.dao.params.PoleTypeParam;
import com.example.support.AppPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.example.analysis.entity.PoleType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 杆样式颜色类型 Mapper 接口
 * </p>
 *
 * @author demo
 * @since 2022-07-06
 */
public interface PoleTypeMapper extends BaseMapper<PoleType> {

	/**
	 * 杆样式颜色类型分页
	 */
	List<PoleType> pageByParam(AppPage<PoleType> appPage, @Param("param") PoleTypeParam param);

}
