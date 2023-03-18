package com.dev.springbootentitiesrestapi.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Getter @Setter
@Entity
@Table(name = "addresses")
public class AddressEntity extends DataItemEntity implements Serializable {

    @EmbeddedId
    @Override
    public BaseComplexObjectID getObjectID() {
        return super.getObjectID();
    }
    @Transient
    private Integer number1;
    @Transient
    private Integer number2;
    @Transient
    private String key;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String strict;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String postalCode;
    @Column(nullable = false)
    private String country;

    public AddressEntity() {

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(number1);
        sb.append("/").append(number2);
        sb.append("/'").append(key).append('\'');
        sb.append(", '").append(street).append('\'');
        sb.append(", '").append(strict).append('\'');
        sb.append(", '").append(city).append('\'');
        sb.append(", '").append(postalCode).append('\'');
        sb.append(", '").append(country).append('\'');
        return sb.toString();
    }
}
