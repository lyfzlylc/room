package com.wangyue.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyue.domain.*;
import com.wangyue.domain.util.Result;
import com.wangyue.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ApplyoutController {
    @Autowired
    private ApplyoutService applyoutService;
    @Autowired
    private HouselistService houselistService;
    @Autowired
    private HetongService hetongService;
    @Autowired
    private CheckoutService checkoutService;
    @Autowired
    private ZulistService zulistService;

    @RequestMapping("/applyout")
    public PageInfo<Applyout> selectAll(@RequestParam(defaultValue = "", value = "search") String search,
                                        @RequestParam(defaultValue = "1", value = "cur") int cur,
                                        @RequestParam(defaultValue = "10", value = "size") int size) {
        PageHelper.startPage(cur, size);
        List<Applyout> applyout = applyoutService.findAll(search);
        PageInfo<Applyout> p = new PageInfo<Applyout>(applyout);
        System.out.println(applyout);
        return p;
    }

    /**
     * 管理员同意退租申请
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/agreeapplyout")
    public Result agreeapplyout(@RequestParam("id") String id) {
        System.out.println("id==>" + id);
        // 修改 houselist 状态 未租赁
        Applyout applyout = applyoutService.findByHouse_idApplyout(id);
        Houselist house = houselistService.findHouse(Integer.parseInt(applyout.getHouse_id()));
        house.setStatus("未租赁");
        houselistService.editHouse(house);
        // 添加 已退租 列表
        Checkout checkout = new Checkout();
        checkout.setHouse_id(applyout.getHouse_id());
        checkout.setAddress(applyout.getAddress());
        checkout.setStatus("已退租");
        checkout.setUser_id(applyout.getUser_id());
        checkoutService.addCheckout(checkout);
        // 修改 退租 申请 ==> 已同意
        applyout.setStatus("已同意");
        applyoutService.updateapplyoutbyhouse(applyout);
        // 删除 合同列表
        hetongService.delHetong(id);
        // 删除 已出租 列表
        zulistService.deleteByHouse_id(applyout.getHouse_id());
        return new Result(200, "成功^v^");
    }

    /**
     * 申请退租信息
     *
     * @param house_id
     * @param model
     * @return
     */
    @RequestMapping("/addApplyout")
    public Result insertapplyout(@RequestParam("house_id") String house_id) {
        System.out.println("addApplyout=》》》》》》》》》》》》》》》》》》》》》");
        System.out.println(house_id);
        Zulist zulist = zulistService.findByHouse_idZulist(house_id);
        System.out.println(zulist);

        Applyout applyout = new Applyout();
        applyout.setHouse_id(zulist.getHouse_id());
        applyout.setAddress(zulist.getAddress());
        applyout.setStatus("申请中");
        applyout.setUser_id(zulist.getUser_id());
        System.out.println(applyout);

        applyoutService.addApplyout(applyout);
        return new Result(200, "申请成功");
    }

    /**
     * 删除 退租列表
     *
     * @param house_id
     * @return
     */
    @RequestMapping("/delapplyout")
    public Result delapplyout(@RequestParam("house_id") String house_id) {
        System.out.println("house_id=》》》》》》》》》》》》》》》》》》》》》");
        System.out.println(house_id);
        // 删除 --退租列表
        applyoutService.delapplyout(house_id);
        return new Result(200, "申请成功");
    }
}
