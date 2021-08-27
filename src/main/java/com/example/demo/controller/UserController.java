package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/insert")
    public Map<String, String> insert(@RequestParam final Map<String, String> param
    // TableDTO tableDTO
    ) {
        Map<String, String> ret = new HashMap<String, String>();

        ret.put("status", "fail");
        String user_name = param.get("user_name");
        String user_email = param.get("user_email");
        String user_password = param.get("user_password");
        String user_phone = param.get("user_phone");
        String user_birthday = param.get("user_birthday");
        User user = new User(user_name, user_email, user_password, user_phone, user_birthday);
        try {
            userMapper.insertUser(user);
            ret.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

}
