package com.example.analysis.service.impl;

import com.example.analysis.dao.converter.IPoleTypeConverter;
import com.example.analysis.dao.params.PoleTypeParam;
import com.example.analysis.dao.vo.PoleTypeVo;
import com.example.support.AppPage;
import com.example.support.PageResult;

import java.util.List;

import com.example.analysis.entity.PoleType;
import com.example.analysis.mapper.PoleTypeMapper;
import com.example.analysis.service.IPoleTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 杆样式颜色类型 服务实现类
 * </p>
 *
 * @author demo
 * @since 2022-07-07
 */
@Service
public class PoleTypeServiceImpl extends ServiceImpl<PoleTypeMapper, PoleType> implements IPoleTypeService {

	/**
	 * 杆样式颜色类型分页
	 */
	@Override
	public PageResult<PoleTypeVo> pagePoleTypeVo(PoleTypeParam param) {
		AppPage<PoleTypeVo> appPage = new AppPage<>(param);
		List<PoleType> entityList = this.lambdaQuery().page(new AppPage<>(param)).getRecords();
		appPage.setRecords(IPoleTypeConverter.INSTANCE.toVoList(entityList));
		return new PageResult<>(appPage);
	}

	/**
	 * 杆样式颜色类型详情
	 */
	@Override
	public PoleTypeVo viewPoleTypeVo(Long id) {
		PoleType entity = this.getById(id);
		return IPoleTypeConverter.INSTANCE.toVo(entity);
	}

	/**
	 * 杆样式颜色类型编辑
	 */
	@Override
	public Integer editPoleTypeVo(PoleTypeVo vo) {
		PoleType entity = IPoleTypeConverter.INSTANCE.toEntity(vo);
		return this.baseMapper.updateById(entity);
	}

	/**
	 * 杆样式颜色类型新增
	 */
	@Override
	public PoleTypeVo addPoleTypeVo(PoleTypeVo vo) {
		PoleType entity = IPoleTypeConverter.INSTANCE.toEntity(vo);
		return this.save(entity) ? IPoleTypeConverter.INSTANCE.toVo(this.getById(entity.getId())) : null;
	}

	/**
	 * 杆样式颜色类型删除
	 */
	@Override
	public Integer removePoleTypeVos(List<Long> ids) {
		return this.baseMapper.deleteBatchIds(ids);
	}


}
