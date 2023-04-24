package com.wangyue.service.Impl;

import com.wangyue.domain.User;
import com.wangyue.mapper.UserMapper;
import com.wangyue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(User user) {
        return userMapper.getUser(user);
    }

    @Override
    public Boolean addUser(User user) {
        return userMapper.addUser(user);
    }
}
