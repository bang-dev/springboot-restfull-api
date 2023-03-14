package com.dev.springbootentitiesrestapi.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataItemEntity extends BaseEntity implements Serializable {
    @Version
    Integer version = 0;
    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt = LocalDateTime.now();
    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt = LocalDateTime.now();
    @CreatedBy
    @Column(name = "created_by")
    String createdBy = "admin";
    @LastModifiedBy
    @Column(name = "updated_by")
    String updatedBy = "admin";
}
