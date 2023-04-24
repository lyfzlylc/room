package com.wangyue.mapper;

import com.wangyue.domain.Userlist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserlistMapper {
    Userlist findByUserid(@Param("userid") Integer userid);
}
