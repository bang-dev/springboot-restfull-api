package com.dev.springbootmongorestapi.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@Getter
@Setter
public class DataBasic implements Serializable {
    @Id
    private String id;
}
