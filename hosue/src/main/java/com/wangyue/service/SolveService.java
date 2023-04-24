package com.wangyue.service;

import com.wangyue.domain.Solve;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SolveService {
    List<Solve> findAll(String search, String date, String date1);

    void addSolve(Solve solve);

    void delsolve(List<Integer> list);

}
