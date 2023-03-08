package com.dev.springbootmongorestapi.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Getter
@Setter
@Document(collection = "users")
public class User extends DataItem implements Serializable {
    private String username;
    private String password;
    private Integer active;
}
