package com.wangyue.service;

import com.wangyue.domain.Topaid;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopaidService {
    List<Topaid> findtopaid(String search);
    List<Topaid> findtopaidByid(@Param("id") Integer id);


    void addtopaid(Topaid topaid);

    Topaid findtopaidByHouse_id(String houseId);

    void deletetopaid(String houseid);
}
