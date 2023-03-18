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
@Table(name = "users2")
public class UserEntity2 extends DataItemEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public String getId() {
        return super.getId();
    }

    private String username;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RoleEntity2$id",updatable = false,insertable = false)
    @Column(name="RoleEntity2$id")
    @Access(AccessType.PROPERTY)
    private RoleEntity2 roleEntity2;
}
