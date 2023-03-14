package com.dev.springbootentitiesrestapi.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Data
@Getter @Setter
@Entity
@Table(name = "profiles")
public class ProfileEntity extends DataItemEntity  implements Serializable {

    @Id
    @Column(name = "id",nullable = false)
    @Override
    public String getId() {
        return super.getId();
    }

    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String birthday;
    private String email;
    private String avatar;
    @Column(name = "auth_token")
    private String authToken;

    @Transient
    private String path;

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
