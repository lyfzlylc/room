package com.wangyue.service;

import com.wangyue.domain.Wrong;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface WrongService {
    List<Wrong> findAll(String user_id);

    Wrong findWrongByid(String id);

    void addWrong(Wrong wrong);

    void delWrong(Integer id);

}
