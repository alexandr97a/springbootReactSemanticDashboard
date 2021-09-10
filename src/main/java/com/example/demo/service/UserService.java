package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDTO;

public interface UserService {
    public List<UserDTO> login(UserDTO userDTO) throws Exception;
}
