package com.example.demo.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // 모든 파라메터를 받는 생성자 자동생성
@NoArgsConstructor
public class UserParam {
    private String user_id;
    private String user_password;
    private String user_name;
    private String user_email;
    private String user_phone;
    private String user_birthday;

    public void set(Map<String, String> param) {
        user_id = param.get("user_id");
        user_password = param.get("user_password");
        user_name = param.get("user_name");
        user_email = param.get("user_email");
        user_phone = param.get("user_phone");
        user_birthday = param.get("user_birthday");
    }

}
