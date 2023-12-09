package com.wangyue.service;

import com.wangyue.domain.User;
import com.wangyue.domain.Userlist;

import java.util.List;

public interface UserlistService {
    Userlist findByUserid(Integer userid);
    void editUser(Userlist userlist);
    List<Userlist> findAll();
    void addUser(User user);
    void delUser(Integer id);
    Userlist findByName(String name);

}
