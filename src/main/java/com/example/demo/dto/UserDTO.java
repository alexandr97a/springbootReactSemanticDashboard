package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long user_id;
    private String user_name;
    private String user_email;
    private String user_password;
    private String user_phone;
    private String user_birthday;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserDTO(String user_name, String user_email, String user_password, String user_phone, String user_birthday) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_phone = user_phone;
        this.user_birthday = user_birthday;
    }
}
