package com.dev.springbootmongorestapi.services;


import com.dev.springbootmongorestapi.entities.Profile;

import java.util.List;

public interface IProfileService {
    List<Profile> all();
    Profile save(Profile profile);
    boolean checkExists(String id);
    Profile findById(String id);
    boolean checkAuthAndEmailExists(String authToken,String email);
    Profile findByEmail(String email);
    Profile getProfile(String autToken, String email);

    Profile updateByFullName(String id,String firstName, String lastName);
    Profile updateByBirthday(String birthday);
    Profile updateByEmail(String email);
    Profile updateByAvatar(String avatar);
    Profile updateAll(String id, String firstName, String lastName,String birthday,String email,String avatar);
}
