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
@Table(name = "users8")
public class UserEntity8 extends DataItemEntity implements Serializable {

    @Id
    @Override
    public String getId() {
        return super.getId();
    }

    private String username;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name = "UserEntity8$id_RoleEntity8$id",
            joinColumns = @JoinColumn(name = "UserEntity8$id"),
            inverseJoinColumns = @JoinColumn(name = "RoleEntity8$id")
    )
    private List<RoleEntity8> roleEntity8s;

}
