package com.wangyue.service.Impl;

import com.wangyue.domain.Houselist;
import com.wangyue.mapper.HouseListMapper;
import com.wangyue.service.HouselistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouselistServiceImpl implements HouselistService {
    @Autowired
    private HouseListMapper houseListMapper;

    @Override
    public List<Houselist> selectAll(String search, String select) {
        return houseListMapper.selectAll(search, select);
    }

    @Override
    public void addHouse(Houselist housel) {
        houseListMapper.addHouse(housel);
    }

    @Override
    public void editHouse(Houselist housel) {
        houseListMapper.editHouse(housel);
    }

    @Override
    public void deleteHouse(List<Integer> list) {
        houseListMapper.deleteHouse(list);
    }

    @Override
    public Houselist findHouse(int houseid) {
        return houseListMapper.findHouse(houseid);
    }
}
