package com.example.analysis.dao.converter;

import com.example.analysis.dao.vo.PoleTypeVo;
import com.example.analysis.entity.PoleType;
import io.swagger.annotations.ApiModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: demo
 * @Date: 2022-07-06T17:06:53.163
 */
@ApiModel(value="PoleTypeConverter", description="杆样式颜色类型转换器")
@Mapper(componentModel = "Spring")
public interface IPoleTypeConverter {

	IPoleTypeConverter INSTANCE = Mappers.getMapper(IPoleTypeConverter.class);

	PoleTypeVo toVo(PoleType entity);

	List<PoleTypeVo> toVoList(List<PoleType> entityList);

}