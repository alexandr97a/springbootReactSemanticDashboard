package com.example.demo.dto;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    private String user_email;
    private String user_password;
    private boolean useCookie;

    public LoginDTO(Map<String, String> param) {
        user_email = param.get("user_email");
        user_password = param.get("user_password");
    }

    public boolean isValid() {
        if (user_email == null)
            return false;
        if (user_password == null)
            return false;
        return true;
    }
}
