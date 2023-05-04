package com.wangyue.service.Impl;

import com.wangyue.domain.Solve;
import com.wangyue.mapper.SolveMapper;
import com.wangyue.service.SolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolveServiceImpl implements SolveService {
    @Autowired
    private SolveMapper solveMapper;

    @Override
    public List<Solve> findAll(String search, String date, String date1) {
        return solveMapper.findAll(search, date, date1);
    }

    @Override
    public List<Solve> findAllByid(Integer id) {
        return solveMapper.findAllByid(id);
    }

    @Override
    public void addSolve(Solve solve) {
        solveMapper.addSolve(solve);
    }

    @Override
    public void delsolve(List<Integer> list) {
        solveMapper.delsolve(list);
    }
}
