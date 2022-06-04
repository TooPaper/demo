package com.example.demo.converter;

import com.example.demo.dto.PersonDTO;
import com.example.demo.dto.PersonVO;
import com.example.demo.entity.Person;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-17T18:29:37+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class IPersonConverterImpl implements IPersonConverter {

    @Override
    public PersonDTO toConvertPersonDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setBirth( person.getBirthday() );
        if ( person.getBirthday() != null ) {
            personDTO.setBirthDateFormat( DateTimeFormatter.ofPattern( "yyyy-HH-dd HH:mm:ss" ).format( person.getBirthday() ) );
        }
        personDTO.setId( person.getId() );
        personDTO.setName( person.getName() );

        return personDTO;
    }

    @Override
    public PersonVO toConvertPersonVO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonVO personVO = new PersonVO();

        personVO.setId( person.getId() );
        personVO.setName( person.getName() );
        personVO.setEmail( person.getEmail() );
        personVO.setBirthday( person.getBirthday() );
        personVO.setUser( person.getUser() );

        return personVO;
    }

    @Override
    public List<PersonVO> toConvertVOList(List<Person> person) {
        if ( person == null ) {
            return null;
        }

        List<PersonVO> list = new ArrayList<PersonVO>( person.size() );
        for ( Person person1 : person ) {
            list.add( toConvertPersonVO( person1 ) );
        }

        return list;
    }
}
