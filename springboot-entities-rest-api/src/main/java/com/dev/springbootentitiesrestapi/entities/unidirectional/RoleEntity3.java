package com.dev.springbootentitiesrestapi.entities.unidirectional;

import com.dev.springbootentitiesrestapi.entities.DataItemEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Getter @Setter
@Entity
@Table(name = "roles3")
public class RoleEntity3 extends DataItemEntity implements Serializable {
    @Id
    @Override
    public String getId() {
        return super.getId();
    }

    private String roleType;
    private String description;


}
