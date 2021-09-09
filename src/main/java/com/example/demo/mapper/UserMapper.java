package com.example.demo.mapper;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserParam;

public interface UserMapper {

    public int insertUser(UserParam userParam);

    public UserDTO getUser(LoginDTO param);
}
