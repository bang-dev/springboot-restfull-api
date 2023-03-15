package com.dev.springbootentitiesrestapi.entities.unidirectional;

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
@Table(name = "users7")
public class UserEntity7 extends DataItemEntity implements Serializable {

    @Id
    @Override
    public String getId() {
        return super.getId();
    }

    private String username;
    private String password;

    @ManyToMany
    private List<RoleEntity7> roleEntity7s;
}
