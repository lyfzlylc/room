package com.wangyue.mapper;

import com.wangyue.domain.Apply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApplyMapper {
    List<Apply> findAll(@Param("search") String search);

    Apply findbyhouse_id(@Param("house_id") String house_id);

    void deleteByHouse_id(@Param("house_id") String house_id);

    void addApply(Apply apply);
}
