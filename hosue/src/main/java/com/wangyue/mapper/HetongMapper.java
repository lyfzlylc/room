package com.wangyue.mapper;

import com.wangyue.domain.Hetong;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HetongMapper {
    void  addHetong(Hetong hetong);
    Hetong findhetong(@Param("house_id") String house_id);
    void delHetong(@Param("house_id") String house_id);
    void editHetong(Hetong hetong);
}
