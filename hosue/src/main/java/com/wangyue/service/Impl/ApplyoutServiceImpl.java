package com.wangyue.service.Impl;

import com.wangyue.domain.Applyout;
import com.wangyue.domain.Checkout;
import com.wangyue.mapper.ApplyoutMapper;
import com.wangyue.service.ApplyoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplyoutServiceImpl implements ApplyoutService {
    @Autowired
    private ApplyoutMapper applyoutMapper;

    @Override
    public List<Applyout> findAll(String search) {
        return applyoutMapper.findAll(search);
    }

    @Override
    public Applyout findByHouse_idApplyout(String aoid) {
        return applyoutMapper.findByHouse_idApplyout(aoid);
    }

    @Override
    public void updateapplyoutbyhouse(Applyout applyout) {
        applyoutMapper.updateapplyoutbyhouse(applyout);
    }

    @Override
    public void addApplyout(Applyout applyout) {
        applyoutMapper.addApplyout(applyout);
    }

    @Override
    public void delapplyout(String house_id) {
        applyoutMapper.delapplyout(house_id);
    }
}
