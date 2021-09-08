package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    private String user_email;
    private String user_password;
    private boolean useCookie;

    public LoginDTO(String user_email, String user_password) {
        this.user_email = user_email;
        this.user_password = user_password;
    }
}
