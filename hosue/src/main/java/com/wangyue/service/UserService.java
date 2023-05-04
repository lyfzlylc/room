package com.wangyue.service;

import com.wangyue.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    User getUser(User user);

    Boolean addUser(User user);

    void editPassword(String password, Integer id);
    void delUser(Integer id);

}
