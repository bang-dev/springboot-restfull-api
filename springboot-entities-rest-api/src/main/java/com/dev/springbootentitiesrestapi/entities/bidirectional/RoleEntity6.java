package com.dev.springbootentitiesrestapi.entities.bidirectional;

import com.dev.springbootentitiesrestapi.entities.DataItemEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Getter @Setter
@Entity
@Table(name = "roles6")
public class RoleEntity6 extends DataItemEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public String getId() {
        return super.getId();
    }

    private String roleType;
    private String description;

    @OneToMany(mappedBy = "roles6",cascade = CascadeType.ALL)
    private List<UserEntity6> userEntity6s;
}
