package com.wangyue.service.Impl;

import com.wangyue.domain.Topaid;
import com.wangyue.mapper.TopaidMapper;
import com.wangyue.service.TopaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopaidServiceImpl implements TopaidService {
    @Autowired
    private TopaidMapper topaidMapper;

    @Override
    public List<Topaid> findtopaid(String search) {
        return topaidMapper.findtopaid(search);
    }

    @Override
    public List<Topaid> findtopaidByid(Integer id) {
        return topaidMapper.findtopaidByid(id);
    }

    @Override
    public void addtopaid(Topaid topaid) {
        topaidMapper.addtopaid(topaid);
    }

    @Override
    public Topaid findtopaidByHouse_id(String houseId) {
        return topaidMapper.findtopaidByHouse_id(houseId);
    }

    @Override
    public void deletetopaid(String houseid) {
        topaidMapper.deletetopaid(houseid);
    }
}
