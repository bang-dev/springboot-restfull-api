package com.dev.springbootmongorestapi.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataItem extends DataBasic implements Serializable {
    @Version
    Integer version = 0;
    @CreatedDate
    @Field(name = "created_at")
    LocalDateTime createdAt = LocalDateTime.now();
    @LastModifiedDate
    @Field(name = "updated_at")
    LocalDateTime updatedAt = LocalDateTime.now();
    @CreatedBy
    @Field(name = "created_by")
    String createdBy = "admin";
    @LastModifiedBy
    @Field(name = "updated_by")
    String updatedBy = "admin";
}
