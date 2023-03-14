package com.dev.springbootentitiesrestapi.enums.impls;

import com.dev.springbootentitiesrestapi.enums.IRole;

public enum EnumRole implements IRole {

    ADMIN("Admin"),USER("User");

    private final String valueRole;


    EnumRole(String valueRole) {
        this.valueRole = valueRole;
    }
    @Override
    public String roleValue() {
        return valueRole;
    }
}
