package com.dev.springbootmongorestapi.dtos;

import com.dev.springbootmongorestapi.utils.GenerateUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Data
@Getter
@Setter
public class UserDTO implements Serializable {
    private String id;
    private String username;
    private String password;
    private Integer active;

    public UserDTO() {
        this.id = GenerateUtils.generateNewId(UUID.randomUUID().toString());
    }
    public UserDTO(String username) {
        this.username = username;
    }
}
