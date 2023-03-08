package com.dev.springbootmongorestapi.entities;

import com.dev.springbootmongorestapi.utils.GenerateUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.UUID;

@Data
@Getter
@Setter
public class DataBasic implements Serializable {
    @Id
    private String id;

    public DataBasic() {
        this.id = GenerateUtils.generateNewId(UUID.randomUUID().toString());
    }
}
