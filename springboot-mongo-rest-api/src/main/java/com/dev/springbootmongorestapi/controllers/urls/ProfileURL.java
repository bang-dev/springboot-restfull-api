package com.dev.springbootmongorestapi.controllers.urls;

import com.dev.springbootmongorestapi.utils.GenerateUtils;

import java.util.UUID;

public class ProfileURL {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static String id;

    public static String getId() {
        if(id == null){
            return GenerateUtils.generateNewId(UUID.randomUUID().toString());
        }
        return id;
    }

    ;
    public static final String ORG_URL = "/api/profiles";
    public static final String ADD_URL = "/add";
    public static final String PARAM = stringBuilder.append(id).toString();
}
