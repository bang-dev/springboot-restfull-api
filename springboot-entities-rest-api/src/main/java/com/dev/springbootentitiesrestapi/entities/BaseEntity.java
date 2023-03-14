package com.dev.springbootentitiesrestapi.entities;

import com.dev.springbootentitiesrestapi.utils.GenerateUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Data
@Getter
@Setter
public class BaseEntity implements Serializable {

    private String id;

    public BaseEntity() {
        this.id = GenerateUtils.generateNewId(UUID.randomUUID().toString());
    }
}
