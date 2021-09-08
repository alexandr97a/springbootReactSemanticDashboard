package com.example.demo.service;

import java.util.Map;

import com.example.demo.dto.LoginDTO;
import com.example.demo.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public LoginDTO login(Map<String, String> map) throws Exception {
        return userMapper.getUser(map);
    }
}
