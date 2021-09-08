package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public Map<String, String> insert(@RequestParam final Map<String, String> param) {
        Map<String, String> ret = new HashMap<String, String>();

        ret.put("status", "fail");
        String user_name = param.get("user_name");
        String user_email = param.get("user_email");
        String user_password = param.get("user_password");
        String user_phone = param.get("user_phone");
        String user_birthday = param.get("user_birthday");
        UserDTO userDTO = new UserDTO(user_name, user_email, user_password, user_phone, user_birthday);
        try {
            userMapper.insertUser(userDTO);
            ret.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @GetMapping(value = "/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam Map<String, String> map, Model model, HttpSession httpSession) {
        try {
            if (map.get("user_email") == null || map.get("user_password") == null) {
                model.addAttribute("msg", "아이디 또는 비밀번호를 입력해주세요");
                return "error/error";
            }
            LoginDTO loginDTO = userService.login(map);
            if (loginDTO != null) {
                httpSession.setAttribute("user", loginDTO);
            } else {
                model.addAttribute("msg", "아이디 또는 비밀번호가 올바르지 않습니다.");
                return "error/error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
            return "error/error";
        }
        return null;

    }

}
