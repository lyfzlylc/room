package com.wangyue.service;

import com.wangyue.domain.Userlist;
import org.apache.ibatis.annotations.Param;

public interface UserlistService {
    Userlist findByUserid(Integer userid);
}
