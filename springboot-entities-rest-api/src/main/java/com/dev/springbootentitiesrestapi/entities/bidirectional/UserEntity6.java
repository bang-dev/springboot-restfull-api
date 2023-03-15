package com.dev.springbootentitiesrestapi.entities.bidirectional;

import com.dev.springbootentitiesrestapi.entities.DataItemEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Getter @Setter
@Entity
public class UserEntity6 extends DataItemEntity implements Serializable {

    @Id
    @Override
    public String getId() {
        return super.getId();
    }

    private String username;
    private String password;

    @ManyToOne
    private RoleEntity6 roleEntity6;
}
