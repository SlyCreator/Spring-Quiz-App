package com.slycreator.springquizapp.service;

import com.slycreator.springquizapp.entity.User;
import com.slycreator.springquizapp.response.AppResponse;

public interface UserService {
    public AppResponse saveUser(User user);
}
