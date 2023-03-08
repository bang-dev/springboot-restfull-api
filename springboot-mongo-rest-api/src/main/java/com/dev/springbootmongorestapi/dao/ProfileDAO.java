package com.dev.springbootmongorestapi.dao;

import com.dev.springbootmongorestapi.entities.Profile;
import com.dev.springbootmongorestapi.exceptions.CustomDataNotFoundException;


// It's similar to repository
public class ProfileDAO {
    public Profile retrieveProfileId(String id){
        try {
            //...
            return null;
        }catch (NullPointerException ex) {
            throw  new CustomDataNotFoundException(ex.getMessage());
        }
    }
}
