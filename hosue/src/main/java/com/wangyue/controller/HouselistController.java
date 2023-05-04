package com.wangyue.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyue.domain.Houselist;
import com.wangyue.domain.util.Result;
import com.wangyue.service.HouselistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HouselistController {
    @Autowired
    private HouselistService houseSevice;

    /**
     * 查询所有 --并分页（插件）
     *
     * @param cur
     * @param size
     * @return
     */
    @RequestMapping("/houselist")
    public PageInfo<Houselist> selectAll(@RequestParam(defaultValue = "1", value = "cur") int cur, @RequestParam(defaultValue = "10", value = "size") int size,
                                         @RequestParam(defaultValue = "", value = "search") String search, @RequestParam(defaultValue = "", value = "select") String select) {
        System.out.println("search==>" + search);
        System.out.println("select==>" + select);
        PageHelper.startPage(cur, size);
        List<Houselist> houselist = houseSevice.selectAll(search, select);
        PageInfo<Houselist> p = new PageInfo<>(houselist);
        return p;
    }

    /**
     * 添加 房屋
     *
     * @param house
     * @return
     */
    @RequestMapping("/addhouse")
    public Result addHouse(@RequestBody Houselist house) {
        if (houseSevice.findHouse(Integer.parseInt(house.getHouseid())) != null)
            return new Result(201, "添加失败");
        houseSevice.addHouse(house);
        return new Result(200, "添加成功");

    }

    @RequestMapping("/edithouse")
    public Result editHouse(@RequestBody Houselist house) {
        houseSevice.editHouse(house);
        return new Result(200, "修改成功");
    }

    @RequestMapping("/deletehouse")
    public Result deleteHouse(@RequestBody List<Integer> list) {
        System.out.println(list);
        houseSevice.deleteHouse(list);
        return new Result(200, "删除成功");
    }
}
