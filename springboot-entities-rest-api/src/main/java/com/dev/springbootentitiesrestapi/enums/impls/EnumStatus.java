package com.dev.springbootentitiesrestapi.enums.impls;


import com.dev.springbootentitiesrestapi.enums.IActive;

public enum EnumStatus implements IActive {
    OPEN(1),CLOSE(0),CANCEL(-1);
    private final int valueActive;

    EnumStatus(int valueActive) {
        this.valueActive = valueActive;
    }


    @Override
    public int activeValue() {
        return valueActive;
    }
}
