package com.dev.springbootmongorestapi.mappers;

import com.dev.springbootmongorestapi.entities.User;
import com.dev.springbootmongorestapi.models.Result;
import com.dev.springbootmongorestapi.utils.DateTimeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

@Mapper(componentModel = "spring",uses = {DateTimeUtils.class})
public interface IEnumMapper {
    @ValueMappings(
            {
                    @ValueMapping(source = "OPEN",target = "OPEN"),
                    @ValueMapping(source = "CLOSE",target = "CLOSE"),
                    @ValueMapping(source = "CANCEL",target = "CANCEL")
            }
    )
    User mapFromProfile(Result enumValue);

}
