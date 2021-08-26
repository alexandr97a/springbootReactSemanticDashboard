package com.example.demo.dao;

import com.example.demo.vo.UserVO;

public interface UserDAO {
    void register(UserVO userVO) throws Exception;
}
