package com.example.demo.service;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UserDTO;

public interface UserService {
    public UserDTO login(LoginDTO loginDTO) throws Exception;
}
