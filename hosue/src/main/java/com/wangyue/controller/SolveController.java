package com.wangyue.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyue.domain.Solve;
import com.wangyue.domain.util.Result;
import com.wangyue.service.SolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class SolveController {
    @Autowired
    private SolveService solveService;

    @RequestMapping("/solvelist")
    public PageInfo<Solve> selectAll(@RequestParam(defaultValue = "", value = "search") String search,
                                     @RequestParam(defaultValue = "", value = "date") String date,
                                     @RequestParam(defaultValue = "", value = "date1") String date1,
                                     @RequestParam(defaultValue = "1", value = "cur") int cur,
                                     @RequestParam(defaultValue = "10", value = "size") int size
    ) {
        System.out.println("search==>" + search);
        System.out.println("date==>" + date);
        System.out.println("date1==>" + date1);
        PageHelper.startPage(cur, size);
        List<Solve> solve = solveService.findAll(search,date,date1);
        PageInfo<Solve> p = new PageInfo<>(solve);
        System.out.println(solve);
        return p;
    }

    /**
     * 删除 已处理报障列表
     *
     * @param list
     * @return
     */
    @RequestMapping("/delsolve")
    public Result delapplyout(@RequestBody List<Integer> list) {
        System.out.println("house_id=》》》》》》》》》》》》》》》》》》》》》");
        System.out.println(list);
        // 删除 --已处理报障
        solveService.delsolve(list);
        return new Result(200, "删除成功");
    }
}
