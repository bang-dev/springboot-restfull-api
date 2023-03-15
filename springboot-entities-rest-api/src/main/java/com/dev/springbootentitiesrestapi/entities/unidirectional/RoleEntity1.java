package com.dev.springbootentitiesrestapi.entities.unidirectional;

import com.dev.springbootentitiesrestapi.entities.DataItemEntity;
import com.dev.springbootentitiesrestapi.enums.impls.EnumRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter @Setter
@Entity
@Table(name = "role1s")
public class RoleEntity1 extends DataItemEntity implements Serializable {

     @Id
     @Column(name = "id")
    @Override
    public String getId() {
        return super.getId();
    }
    private String roleType;
    private String description;


}
