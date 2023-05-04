package com.wangyue.mapper;

import com.wangyue.domain.Zulist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ZulistMapper {
    List<Zulist> findAll(@Param("search") String search, @Param("username") String username);

    Zulist findByHouse_idZulist(@Param("house_id") String house_id);

    void deleteByHouse_id(@Param("house_id") String house_id);

    void addzulist(Zulist zulist);
}
