package com.wangyue.service.Impl;

import com.wangyue.domain.Userlist;
import com.wangyue.mapper.UserlistMapper;
import com.wangyue.service.UserlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserlistServiceImpl implements UserlistService {
    @Autowired
    private UserlistMapper userlistMapper;
    @Override
    public Userlist findByUserid(Integer userid) {
        return userlistMapper.findByUserid(userid);
    }
}
