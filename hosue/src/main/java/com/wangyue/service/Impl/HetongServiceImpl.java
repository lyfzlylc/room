package com.wangyue.service.Impl;

import com.wangyue.domain.Hetong;
import com.wangyue.mapper.HetongMapper;
import com.wangyue.service.HetongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HetongServiceImpl implements HetongService {
    @Autowired
    private HetongMapper hetongMapper;

    @Override
    public void addHetong(Hetong hetong) {
        hetongMapper.addHetong(hetong);
    }

    @Override
    public Hetong findhetong(String house_id) {
        return hetongMapper.findhetong(house_id);
    }

    @Override
    public void delHetong(String house_id) {
        hetongMapper.delHetong(house_id);
    }

    @Override
    public void editHetong(Hetong hetong) {
        hetongMapper.editHetong(hetong);
    }
}
