package com.wangyue.service.Impl;

import com.wangyue.domain.Zulist;
import com.wangyue.mapper.ZulistMapper;
import com.wangyue.service.ZulistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZulistServiceImpl implements ZulistService {
    @Autowired
    private ZulistMapper zulistMapper;

    @Override
    public List<Zulist> findAll(String search) {
        return zulistMapper.findAll(search);
    }

    @Override
    public Zulist findByHouse_idZulist(String house_id) {
        return zulistMapper.findByHouse_idZulist(house_id);
    }

    @Override
    public void deleteByHouse_id(String house_id) {
        zulistMapper.deleteByHouse_id(house_id);
    }

    @Override
    public void addzulist(Zulist zulist) {
        zulistMapper.addzulist(zulist);
    }
}
