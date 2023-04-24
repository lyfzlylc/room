package com.wangyue.mapper;

import com.wangyue.domain.Wrong;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WrongMapper {
    List<Wrong> findAll(@Param("user_id") String user_id);
    Wrong findWrongByid(@Param("id") String id);

    void addWrong(Wrong wrong);

    void delWrong(@Param("id") Integer id);
}
