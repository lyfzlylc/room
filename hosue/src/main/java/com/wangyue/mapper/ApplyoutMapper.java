package com.wangyue.mapper;

import com.wangyue.domain.Applyout;
import com.wangyue.domain.Checkout;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApplyoutMapper {
    List<Applyout> findAll(@Param("search") String search);

    Applyout findByHouse_idApplyout(@Param("aoid") String aoid);

    void updateapplyoutbyhouse(Applyout applyout);

    void addApplyout(Applyout applyout);

    void delapplyout(@Param("house_id") String house_id);
}
