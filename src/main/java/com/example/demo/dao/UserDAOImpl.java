package com.example.demo.dao;

import javax.inject.Inject;

import com.example.demo.vo.UserVO;

import org.apache.ibatis.session.SqlSession;

public class UserDAOImpl implements UserDAO {
    private static final String NAMESPACE = "com.example.demo.mapper.UserMapper";
    private final SqlSession sqlSession;

    @Inject
    public UserDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void register(UserVO userVO) throws Exception {
        sqlSession.insert(NAMESPACE + ".register", userVO);
    }

}
