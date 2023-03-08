package com.dev.springbootmongorestapi.builders;


import com.dev.springbootmongorestapi.entities.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class UserBuilder implements Serializable {
    private User user;

    public UserBuilder builderID(String id){
        user.setId(id);
        return this;
    }

    public UserBuilder builderUsername(String username){
        user.setUsername(username);
        return this;
    }
    public UserBuilder builderPassword(String password){
        user.setPassword(password);
        return this;
    }
    public UserBuilder builderActive(Integer active){
        user.setActive(active);
        return this;
    }

    public User builder(){
        return user;
    }
}
