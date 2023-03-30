package com.dev.builders;

import com.dev.dtos.PersonalDTO;

public class PersonalBuilder {
    private PersonalDTO personalDTO;
    public PersonalBuilder personalBuilderID(String id){
        personalDTO.setId(id);
        return this;
    }
    public PersonalBuilder personalBuilderFirstName(String firstName){
        personalDTO.setFirstName(firstName);
        return this;
    }
    public PersonalBuilder personalBuilderLastName(String lastName){
        personalDTO.setLastName(lastName);
        return this;
    }
    public PersonalBuilder personalBuilderMajor(String major){
        personalDTO.setMajor(major);
        return this;
    }

    public PersonalDTO builder(){
        return personalDTO;
    }
}
