package com.dev.springbootmongorestapi.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Getter
@Setter
@Document(collection = "profiles")
public class Profile extends DataItem implements Serializable {
    private String firstName;
    private String lastName;
    private String birthday;
    private String email;
    private String avatar;
    private String authToken;

    @Transient
    private String path;

}
