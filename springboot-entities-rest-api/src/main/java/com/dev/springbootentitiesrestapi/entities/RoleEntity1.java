package com.dev.springbootentitiesrestapi.entities;

import com.dev.springbootentitiesrestapi.enums.impls.EnumRole;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Getter @Setter
/*@Entity*/
/*@Table(name = "role1s")*/
public class RoleEntity1 extends DataItemEntity implements Serializable {
    @Override
    public String getId() {
        return super.getId();
    }
    private EnumRole roleType;
    private String description;
}
