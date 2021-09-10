package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.Map;

import com.mysql.cj.util.StringUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long user_no;
    private LocalDateTime createdate;
    private LocalDateTime updatedate;

    private String user_id;
    private String user_password;
    private String user_name;
    private String user_email;
    private String user_phone;
    private String user_birthday;

    public boolean setSignUp(Map<String, String> param) {
        user_id = param.get("user_id");
        user_password = param.get("user_password");
        user_name = param.get("user_name");
        user_email = param.get("user_email");
        user_phone = param.get("user_phone");
        user_birthday = param.get("user_birthday");

        if (user_id != null)
            user_id = user_id.trim();
        if (StringUtils.isNullOrEmpty(user_id))
            return false;

        if (user_password != null)
            user_password = user_password.trim();
        if (StringUtils.isNullOrEmpty(user_password))
            return false;

        if (user_name != null)
            user_name = user_name.trim();
        if (StringUtils.isNullOrEmpty(user_name))
            return false;

        if (user_email != null)
            user_email = user_email.trim();
        if (StringUtils.isNullOrEmpty(user_email))
            return false;

        if (user_phone != null)
            user_phone = user_phone.trim();
        if (StringUtils.isNullOrEmpty(user_phone))
            return false;

        if (user_birthday != null)
            user_birthday = user_birthday.trim();
        if (StringUtils.isNullOrEmpty(user_birthday))
            return false;

        return true;
    }

    public boolean setLogin(Map<String, String> param) {
        user_email = param.get("user_email");
        user_password = param.get("user_password");

        if (user_email == null)
            user_email = user_email.trim();
        if (StringUtils.isNullOrEmpty(user_email))
            return false;
        if (user_password == null)
            user_password = user_password.trim();
        if (StringUtils.isNullOrEmpty(user_password))
            return false;
        return true;
    }
}
