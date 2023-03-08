package com.dev.springbootmongorestapi.services;

import com.dev.springbootmongorestapi.entities.User;

import java.util.List;

public interface IUserService {
    List<User> all();
    User save(User user);
}
