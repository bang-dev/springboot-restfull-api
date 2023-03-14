package com.dev.springbootentitiesrestapi.utils;

import java.util.UUID;

public class GenerateUtils {
    public static String generateNewId(String id){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
