package com.dev.springbootmongorestapi.responses;

public class GenericInfo<T> {
    public T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
