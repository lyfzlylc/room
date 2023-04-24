package com.wangyue.service;

import com.wangyue.domain.Apply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplyService {
    List<Apply> findAll(String search);
    Apply findbyhouse_id(String house_id);
    void deleteByHouse_id(String house_id);
    void addApply(Apply apply);


}
