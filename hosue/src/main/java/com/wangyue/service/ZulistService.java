package com.wangyue.service;

import com.wangyue.domain.Zulist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZulistService {
    List<Zulist> findAll(String search,String username);
    Zulist findByHouse_idZulist(String house_id);
    void deleteByHouse_id(String house_id);
    void addzulist(Zulist zulist);

}
