package com.example.demo.mapper;

import java.util.Map;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UserDTO;

public interface UserMapper {

    public int insertUser(UserDTO userDTO);

    public LoginDTO getUser(Map<String, String> map);
}
