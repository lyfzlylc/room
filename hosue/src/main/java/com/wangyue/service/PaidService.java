package com.wangyue.service;

import com.wangyue.domain.Paid;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaidService {
    List<Paid> findAll(String search, String date, String date1, Integer id);

    void addPaid(Paid paid);

    void deletePaid(List<Integer> list);

}
