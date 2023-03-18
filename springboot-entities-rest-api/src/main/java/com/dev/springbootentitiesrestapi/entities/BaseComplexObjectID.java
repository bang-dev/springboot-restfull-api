package com.dev.springbootentitiesrestapi.entities;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Embeddable
public class BaseComplexObjectID implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer number;
    private String text;

    public BaseComplexObjectID() {
    }

    public BaseComplexObjectID(Integer number, String text) {
        this.number = number;
        this.text = text;
    }


    /**
        @author: Bang Vo Anh
        @since: 03/16/2023 03:02 PM
        @description:
                    - An Embeddable class which is used as an EmbeddedId should implement.
                    - toString() having a unique returned value.
        @update:
    **/

    @Override
    public String toString() {
        return number.toString() + text;
    }


}
