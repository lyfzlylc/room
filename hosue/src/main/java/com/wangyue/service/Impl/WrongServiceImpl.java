package com.wangyue.service.Impl;

import com.wangyue.domain.Wrong;
import com.wangyue.mapper.WrongMapper;
import com.wangyue.service.WrongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WrongServiceImpl implements WrongService {
    @Autowired
    private WrongMapper wrongMapper;

    @Override
    public List<Wrong> findAll(String user_id) {
        return wrongMapper.findAll(user_id);
    }

    @Override
    public Wrong findWrongByid(String id) {
        return wrongMapper.findWrongByid(id);
    }

    @Override
    public void addWrong(Wrong wrong) {
        wrongMapper.addWrong(wrong);
    }

    @Override
    public void delWrong(Integer id) {
        wrongMapper.delWrong(id);
    }
}
