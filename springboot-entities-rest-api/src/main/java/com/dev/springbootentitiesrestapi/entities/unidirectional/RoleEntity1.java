package com.dev.springbootentitiesrestapi.entities.unidirectional;

import com.dev.springbootentitiesrestapi.entities.DataItemEntity;
import com.dev.springbootentitiesrestapi.enums.impls.EnumRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Getter @Setter
@Entity
@Table(name = "role1s")
public class RoleEntity1 extends DataItemEntity implements Serializable {

     @Id
     @Column(name = "id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public String getId() {
        return super.getId();
    }
    private String roleType;
    private String description;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleEntity1)) return false;
        if (!super.equals(o)) return false;
        RoleEntity1 that = (RoleEntity1) o;
        return getRoleType().equals(that.getRoleType()) && getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRoleType(), getDescription());
    }
}
