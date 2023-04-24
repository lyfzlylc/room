package com.wangyue.mapper;

import com.wangyue.domain.Topaid;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TopaidMapper {
    List<Topaid> findtopaid(@Param("search") String search);
    void addtopaid(Topaid topaid);
    Topaid findtopaidByHouse_id(@Param("houseid") String houseid);
    void deletetopaid(@Param("houseid") String houseid);
}
