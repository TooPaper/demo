package com.example.demo.converter;

import com.example.demo.dto.PersonDTO;
import com.example.demo.dto.PersonVO;
import com.example.demo.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/* 1.源对象属性 与 目标对象属性 名字一致，自动映射对应属性
 * 2.支持表达式的方式,例如可以用 format 转成自己想要的类型
 * 3.如果某个属性你不想映射，可以加个 ignore=true
 * 4.可以看到像 id、name、email这些名词一致的我并没有指定 source-target
 * 而birthday-birth指定了，转换格式的 birthDateFormat 加了dateFormat
 * 或者 birthExpressionFormat 加了 expression
 */
@Mapper(componentModel = "Spring")
public interface IPersonConverter {

    IPersonConverter INSTANCE = Mappers.getMapper(IPersonConverter.class);

    @Mapping(source = "birthday",target = "birth")
    @Mapping(source = "birthday",target = "birthDateFormat",dateFormat = "yyyy-HH-dd HH:mm:ss")
    @Mapping(source = "email",target = "email",ignore = true)
    PersonDTO toConvertPersonDTO(Person person);

    PersonVO toConvertPersonVO(Person person);

    List<PersonVO> toConvertVOList(List<Person> person);

}
