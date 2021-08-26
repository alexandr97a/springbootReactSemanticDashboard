package com.example.demo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserVO {
    private String user_id;
    private String user_name;
    private String user_password;
    private String user_phone;
    private String user_birthday;
}
