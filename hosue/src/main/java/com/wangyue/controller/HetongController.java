package com.wangyue.controller;

import com.wangyue.domain.*;
import com.wangyue.domain.util.Result;
import com.wangyue.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HetongController {
    @Autowired
    private HouselistService houselistService;
    @Autowired
    private ApplyService applyService;
    @Autowired
    private ZulistService zulistService;
    @Autowired
    private CheckoutService checkoutService;
    @Autowired
    private HetongService hetongService;

    /**
     * 终止合同
     *
     * @param house_id
     * @return
     */
    @RequestMapping("/deletehetong")
    public Result DeleteHetong(@RequestParam("house_id") String house_id) {
        System.out.println("house_id==>" + house_id);
        //  通过 id 查找该房信息
        Zulist zulist = zulistService.findByHouse_idZulist(house_id);
        if (zulist == null)
            new Result(201, "错误提交！");
        //  添加 到退租列表
        Checkout checkout = new Checkout();
        checkout.setHouse_id(house_id);
        checkout.setAddress(zulist.getAddress());
        checkout.setStatus("已退租");
        checkout.setUser_id(zulist.getUser_id());
        checkoutService.addCheckout(checkout);
        // 修改 house表状态为 未租赁
        Houselist houselist = houselistService.findHouse(Integer.parseInt(house_id));
        houselist.setStatus("未租赁");
        houselistService.editHouse(houselist);
        // 删除 合同列表
        hetongService.delHetong(house_id);
        // 删除 租房列表
        zulistService.deleteByHouse_id(house_id);
        return new Result(200, "成功");
    }

    /**
     * 同意租赁
     *
     * @param hetong
     * @return
     */
    @RequestMapping("/addhetong")
    public Result addhetong(@RequestBody Hetong hetong) {
        System.out.println(hetong);
        // 同意租赁
        Hetong findhetong = hetongService.findhetong(hetong.getHouse_id());
        findhetong.setChuzu(hetong.getChuzu());
        findhetong.setChuzu_idcard(hetong.getChuzu_idcard());
        findhetong.setPrice(hetong.getPrice());
        findhetong.setPayday(hetong.getPayday());
        hetongService.editHetong(findhetong);
        //修改房屋列表状态
        Houselist houselist = houselistService.findHouse(Integer.parseInt(hetong.getHouse_id()));
        houselist.setStatus("已租赁");
        houselistService.editHouse(houselist);
        //添加到租赁列表当中
        Zulist zulist = new Zulist();
        Hetong hetong1 = hetongService.findhetong(hetong.getHouse_id());
        Apply apply = applyService.findbyhouse_id(hetong.getHouse_id());
        System.out.println(apply);
        zulist.setHouse_id(hetong.getHouse_id());
        zulist.setUser_id(apply.getUser_id());
        zulist.setContract_id(hetong1.getId());
        zulist.setPrice(apply.getPrice());
        System.out.println(zulist);
        zulist.setAddress(apply.getAddress());
        zulistService.addzulist(zulist);
        //从申请列表中删除
        applyService.deleteByHouse_id(hetong.getHouse_id());
        return new Result(200, "成功");
    }

    @RequestMapping("/findHetong")
    public Result fidnHeong(@RequestParam("house_id") String house_id) {
        return new Result(200, hetongService.findhetong(house_id), "成功");
    }

    @RequestMapping("/edithetong")
    public Result edithetong(@RequestParam("house_id") String house_id) {
        Hetong findhetong = hetongService.findhetong(house_id);
        hetongService.editHetong(findhetong);
        return new Result(200, "成功");
    }
}
