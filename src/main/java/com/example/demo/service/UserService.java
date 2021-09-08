package com.example.demo.service;

import java.util.Map;

import com.example.demo.dto.LoginDTO;

public interface UserService {
    public LoginDTO login(Map<String, String> map) throws Exception;
}
