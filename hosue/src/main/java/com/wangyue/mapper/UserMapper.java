package com.wangyue.mapper;

import com.wangyue.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User getUser(User user);
    Boolean addUser(User user);
    void editPassword(@Param("password") String password,@Param("id") Integer id);
    void delUser(@Param("id") Integer id);
}
