package com.dev.springbootmongorestapi.services.impls;

import com.dev.springbootmongorestapi.entities.User;
import com.dev.springbootmongorestapi.services.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public List<User> all() {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }
}
