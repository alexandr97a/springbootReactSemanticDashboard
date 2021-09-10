package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public Map<String, String> insert(@RequestParam final Map<String, String> param) {
        Map<String, String> ret = new HashMap<String, String>();

        ret.put("status", "fail");
        UserDTO userDTO = new UserDTO();
        boolean valid = userDTO.setSignUp(param);
        if (!valid)
            return ret;

        try {
            userMapper.insertUser(userDTO);
            ret.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestParam Map<String, String> map, Model model, HttpSession httpSession) {
        Map<String, String> ret = new HashMap<String, String>();
        ret.put("status", "fail");
        try {
            UserDTO userDTO = new UserDTO();
            boolean valid = userDTO.setLogin(map);

            if (!valid) {
                ret.put("msg", "아이디 또는 비밀번호를 입력해주세요");
                return ret;
            }

            List<UserDTO> listUserDTO = userService.login(userDTO);
            if (listUserDTO.size() == 0) {
                ret.put("msg", "아이디 또는 비밀번호가 올바르지 않습니다.");
                return ret;
            }

            userDTO = listUserDTO.get(0);
            httpSession.setAttribute("user", userDTO);
            ret.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            ret.put("msg", "로그인 중 문제가 발생했습니다.");
            return ret;
        }
        return ret;

    }

}
