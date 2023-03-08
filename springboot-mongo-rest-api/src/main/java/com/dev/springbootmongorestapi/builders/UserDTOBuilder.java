package com.dev.springbootmongorestapi.builders;

import com.dev.springbootmongorestapi.dtos.UserDTO;
import com.dev.springbootmongorestapi.entities.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class UserDTOBuilder implements Serializable {
    private UserDTO userDTO;

    public UserDTOBuilder builderIdDTO(String id){
        userDTO.setId(id);
        return this;
    }

    public UserDTOBuilder builderUsernameDTO(String username){
        userDTO.setUsername(username);
        return this;
    }
    public UserDTOBuilder builderPasswordDTO(String password){
        userDTO.setPassword(password);
        return this;
    }
    public UserDTOBuilder builderActiveDTO(Integer active){
        userDTO.setActive(active);
        return this;
    }

    public UserDTO builder(){
        return userDTO;
    }
}
