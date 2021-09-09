package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends UserParam {
    private Long user_no;
    private LocalDateTime createdate;
    private LocalDateTime updatedate;
}
