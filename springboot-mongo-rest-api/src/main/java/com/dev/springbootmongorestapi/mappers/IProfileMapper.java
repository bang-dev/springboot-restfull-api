package com.dev.springbootmongorestapi.mappers;

import com.dev.springbootmongorestapi.dtos.ProfileDTO;
import com.dev.springbootmongorestapi.entities.Profile;
import com.dev.springbootmongorestapi.utils.DateTimeUtils;
import com.dev.springbootmongorestapi.utils.HcUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DateTimeUtils.class},imports = {HcUtils.class})
public interface IProfileMapper {
    @Mapping(source = "id",target = "id")
    @Mapping(source = "firstName",target = "firstName")
    @Mapping(source = "lastName",target = "lastName")
    @Mapping(source = "birthday",target = "birthday")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "avatar",target = "avatar")
    @Mapping(source = "path",target = "path")
    @Mapping(source = "authToken",target = "authToken")
    @Mapping(target = "version",ignore = true)
    @Mapping(target = "createdDate",ignore = true)
    @Mapping(target = "updatedDate",ignore = true)
    @Mapping(target = "createdBy",ignore = true)
    @Mapping(target = "updatedBy",ignore = true)
    ProfileDTO convertFromProfileToProfileDto(Profile profile);


    @Mapping(source = "id",target = "id")
    @Mapping(source = "firstName",target = "firstName")
    @Mapping(source = "lastName",target = "lastName")
    @Mapping(source = "birthday",target = "birthday")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "avatar",target = "avatar")
    @Mapping(source = "path",target = "path")
    @Mapping(source = "authToken",target = "authToken")
    @Mapping(target = "version",ignore = true)
    @Mapping(target = "createdDate",ignore = true)
    @Mapping(target = "updatedDate",ignore = true)
    @Mapping(target = "createdBy",ignore = true)
    @Mapping(target = "updatedBy",ignore = true)
    Profile convertFromProfileDtoToProfile(ProfileDTO profileDto);


    List<ProfileDTO> convertFromListProfileToListProfileDto(List<Profile> profiles);
    List<Profile> convertFromListProfileDtoToListProfile(List<ProfileDTO> profileDtoList);

}
