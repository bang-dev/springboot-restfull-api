package com.dev.springbootentitiesrestapi.entities.bidirectional;

import com.dev.springbootentitiesrestapi.entities.DataItemEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@Getter @Setter
@Entity
@Table(name = "roles8")
public class RoleEntity8 extends DataItemEntity implements Serializable {

    @Id
    @Override
    public String getId() {
        return super.getId();
    }

    private String roleType;
    private String description;

    @ManyToMany
    private List<UserEntity8> userEntity8s;
}
