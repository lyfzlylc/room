package com.wangyue.mapper;

import com.wangyue.domain.Solve;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SolveMapper {
    List<Solve> findAll(@Param("search") String search, @Param("date") String date, @Param("date1") String date1);

    void addSolve(Solve solve);

    void delsolve(List list);
}
