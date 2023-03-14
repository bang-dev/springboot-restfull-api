package com.dev.springbootmongorestapi.dtos;

import com.dev.springbootmongorestapi.utils.GenerateUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Getter
@Setter
@ApiModel(value = "ProfileDTO", description = "A profile with info by the attributes.")
public class ProfileDTO implements Serializable {
    @ApiModelProperty(value = "The profile ID", example = "12312a1sadads54ad5sa6sa...")
    private String id;
    @ApiModelProperty(value = "The profile first name", example = "Bằng")
    private String firstName;
    @ApiModelProperty(value = "The profile last name", example = "Võ Anh")
    private String lastName;
    @ApiModelProperty(value = "The profile birthday", example = "05-12-1997")
    private String birthday;
    @ApiModelProperty(value = "The profile email", example = "anhbangluckystar@gmail.com")
    private String email;
    @ApiModelProperty(value = "The profile avatar", example = "images...")
    private String avatar;
    @ApiModelProperty(value = "The profile path", example = "url...")
    private String path;
    private String authToken;
    @ApiModelProperty(value = "The profile version", example = "version of profile after create, update")
    private Integer version;
    @ApiModelProperty(value = "The profile createdAt", example = "created by current time")
    private LocalDateTime createdAt;
    @ApiModelProperty(value = "The profile updatedAt", example = "updated by current time")
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updateBy;

    public ProfileDTO() {
        this.id = GenerateUtils.generateNewId(UUID.randomUUID().toString());
    }
}
