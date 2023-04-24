package com.wangyue.service;

import com.wangyue.domain.User;

public interface UserService {
    User getUser(User user);

    Boolean addUser(User user);

}
