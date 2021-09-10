package com.example.demo.mapper;

import java.util.List;

import com.example.demo.dto.UserDTO;

public interface UserMapper {

    public int insertUser(UserDTO userDTO);

    public List<UserDTO> getUser(UserDTO param);
}
