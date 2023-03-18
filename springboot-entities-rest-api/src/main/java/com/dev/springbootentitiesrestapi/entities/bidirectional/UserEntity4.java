package com.dev.springbootentitiesrestapi.entities.bidirectional;

import com.dev.springbootentitiesrestapi.entities.DataItemEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter @Setter
@Entity
@Table(name = "users4")
public class UserEntity4 extends DataItemEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public String getId() {
        return super.getId();
    }

    private String username;
    private String password;

    @OneToMany(mappedBy = "userEntity4")
    private RoleEntity4 roleEntity4;


}
