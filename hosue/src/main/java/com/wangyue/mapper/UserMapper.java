package com.wangyue.mapper;

import com.wangyue.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUser(User user);
    Boolean addUser(User user);
}
