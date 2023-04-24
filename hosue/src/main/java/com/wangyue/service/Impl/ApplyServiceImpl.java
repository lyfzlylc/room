package com.wangyue.service.Impl;

import com.wangyue.domain.Apply;
import com.wangyue.mapper.ApplyMapper;
import com.wangyue.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyMapper applyMapper;

    @Override
    public List<Apply> findAll(String search) {
        return applyMapper.findAll(search);
    }

    @Override
    public Apply findbyhouse_id(String house_id) {
        return applyMapper.findbyhouse_id(house_id);
    }

    @Override
    public void deleteByHouse_id(String house_id) {
        applyMapper.deleteByHouse_id(house_id);
    }

    @Override
    public void addApply(Apply apply) {
        applyMapper.addApply(apply);
    }
}
