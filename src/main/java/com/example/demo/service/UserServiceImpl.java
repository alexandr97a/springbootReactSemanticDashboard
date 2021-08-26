package com.example.demo.service;

import javax.inject.Inject;

import com.example.demo.dao.UserDAO;
import com.example.demo.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Inject
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void register(UserVO userVO) throws Exception {
        userDAO.register(userVO);
    }

}
