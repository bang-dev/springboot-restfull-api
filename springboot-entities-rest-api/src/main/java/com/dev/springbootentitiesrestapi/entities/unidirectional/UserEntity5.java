package com.dev.springbootentitiesrestapi.entities.unidirectional;

import com.dev.springbootentitiesrestapi.entities.DataItemEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Getter @Setter
@Entity
@Table(name = "users5")
public class UserEntity5 extends DataItemEntity implements Serializable {

    @Id
    @Override
    public String getId() {
        return super.getId();
    }

    private String username;
    private String password;

    @ManyToOne
    private RoleEntity5 roleEntity5;
}
