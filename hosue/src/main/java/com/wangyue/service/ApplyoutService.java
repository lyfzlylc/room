package com.wangyue.service;

import com.wangyue.domain.Applyout;
import com.wangyue.domain.Checkout;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplyoutService {
    List<Applyout> findAll(String search);

    Applyout findByHouse_idApplyout(String aoid);

    void updateapplyoutbyhouse(Applyout applyout);
    void addApplyout(Applyout applyout);
    void delapplyout(String house_id);


}
