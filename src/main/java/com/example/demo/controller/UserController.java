package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.vo.UserVO;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerGET() throws Exception {
        return "/user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPOST(UserVO userVO, RedirectAttributes redirectAttributes) throws Exception {
        String hashedPw = BCrypt.hashpw(userVO.getUser_password(), BCrypt.gensalt());
        userVO.setUser_password(hashedPw);
        userService.register(userVO);
        redirectAttributes.addFlashAttribute("msg", "REGISTERED");
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() throws Exception {
        return "/user/login";
    }

    // @PostMapping("/insert")
    // public Map<String, String> insert(@RequestParam final Map<String, String>
    // param
    // // TableDTO tableDTO
    // ) {
    // Map<String, String> ret = new HashMap<String, String>();

    // ret.put("status", "fail");
    // String user_name = param.get("user_name");
    // String user_email = param.get("user_email");
    // String user_password = param.get("user_password");
    // String user_phone = param.get("user_phone");
    // String user_birthday = param.get("user_birthday");
    // User user = new User(user_name, user_email, user_password, user_phone,
    // user_birthday);
    // try {
    // userMapper.insertUser(user);
    // ret.put("status", "success");
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // return ret;
    // }

}
