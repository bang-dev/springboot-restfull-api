package com.dev.springbootmongorestapi.dtos;

import com.dev.springbootmongorestapi.utils.GenerateUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Getter
@Setter
public class ProfileDTO implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String birthday;
    private String email;
    private String avatar;
    private String path;
    private String authToken;
    private Integer version;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updateBy;

    public ProfileDTO() {
        this.id = GenerateUtils.generateNewId(UUID.randomUUID().toString());
    }
}
