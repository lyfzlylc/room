package com.wangyue.mapper;

import com.wangyue.domain.User;
import com.wangyue.domain.Userlist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserlistMapper {
    Userlist findByUserid(@Param("userid") Integer userid);
    Userlist findByName(@Param("name") String name);

    void editUser(Userlist userlist);

    List<Userlist> findAll();

    void addUser(User user);
    void delUser(@Param("id") Integer id);
}
