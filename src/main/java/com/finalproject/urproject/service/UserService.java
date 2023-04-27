package com.finalproject.urproject.service;

import com.finalproject.urproject.dto.UserDto;
import com.finalproject.urproject.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
}
