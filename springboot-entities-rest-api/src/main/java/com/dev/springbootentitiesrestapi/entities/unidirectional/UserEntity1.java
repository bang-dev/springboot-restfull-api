package com.dev.springbootentitiesrestapi.entities.unidirectional;

import com.dev.springbootentitiesrestapi.entities.DataItemEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Getter @Setter
@Entity
@Table(name = "user1s")
public class UserEntity1 extends DataItemEntity implements Serializable {
    @Id
    @Column(name = "id")
    @Override
    public String getId() {
        return super.getId();
    }

    private String username;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="RoleEntity1$id", insertable=false ,updatable=false)
    @Column(name="RoleEntity1$id")
    @Access(AccessType.PROPERTY)
    private RoleEntity1 roleEntity1;


    @Override
    public Integer getVersion() {
        return super.getVersion();
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return super.getCreatedAt();
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return super.getUpdatedAt();
    }

    @Override
    public String getCreatedBy() {
        return super.getCreatedBy();
    }

    @Override
    public String getUpdatedBy() {
        return super.getUpdatedBy();
    }
}
