package com.dev.springbootentitiesrestapi.entities.bidirectional;

import com.dev.springbootentitiesrestapi.entities.DataItemEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter @Setter
@Entity
@Table(name = "roles4")
public class RoleEntity4 extends DataItemEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public String getId() {
        return super.getId();
    }

    private String roleType;
    private String description;

    @ManyToOne
    private UserEntity4 userEntity4;
}
