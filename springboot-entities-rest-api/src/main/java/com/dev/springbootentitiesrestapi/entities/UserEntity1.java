package com.dev.springbootentitiesrestapi.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
