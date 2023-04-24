package com.wangyue.mapper;

import com.wangyue.domain.Houselist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HouseListMapper {
    List<Houselist> selectAll(@Param("search") String search,@Param("select") String select);
    void addHouse(Houselist housel);
    void editHouse(Houselist housel);
    void deleteHouse(@Param("list") List<Integer> list);
    Houselist findHouse(@Param("houseid") int houseid);
}
