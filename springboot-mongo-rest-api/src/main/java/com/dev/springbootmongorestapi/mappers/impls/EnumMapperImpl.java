package com.dev.springbootmongorestapi.mappers.impls;

import com.dev.springbootmongorestapi.entities.User;
import com.dev.springbootmongorestapi.mappers.IEnumMapper;
import com.dev.springbootmongorestapi.models.Result;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-03-11T19:21:44+0100",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class EnumMapperImpl implements IEnumMapper {
    @Override
    public User mapFromProfile(Result enumValue) {
        if(null == enumValue){
            return null;
        }
        User  user = new User();
        user.setActive(enumValue.getValueInt());
        return user;

    }
}
