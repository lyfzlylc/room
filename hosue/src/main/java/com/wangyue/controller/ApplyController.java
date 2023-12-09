package com.wangyue.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyue.domain.*;
import com.wangyue.domain.util.Result;
import com.wangyue.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
public class ApplyController {
    @Autowired
    private ApplyService ApplyService;
    @Autowired
    private UserlistService userlistService;
    @Autowired
    private HouselistService houselistService;
    @Autowired
    private ApplyService applyService;
    @Autowired
    private ApplyoutService applyoutService;
    @Autowired
    private HetongService hetongService;

    @RequestMapping("/applylist")
    public PageInfo<Apply> selectAll(@RequestParam(defaultValue = "", value = "search") String search,
                                     @RequestParam(defaultValue = "1", value = "cur") int cur,
                                     @RequestParam(defaultValue = "10", value = "size") int size) {
        PageHelper.startPage(cur, size);
        List<Apply> apply = ApplyService.findAll(search);
        PageInfo<Apply> p = new PageInfo<>(apply);
        System.out.println(apply);
        return p;
    }

    /**
     * 申请看房
     *
     * @param httpSession
     * @param
     * @param
     * @return
     */
    @RequestMapping("/applycheckuserlist")
    public Result applycheckuserlist(HttpSession httpSession, @RequestBody Hetong hetong) {
        System.out.println(hetong);
        User user1 = (User) httpSession.getAttribute("user");
        Integer user_id = user1.getId();
        System.out.println(user1);
        System.out.println("houseid==>" + hetong.getHouse_id());
        Userlist list = userlistService.findByUserid(user_id);
        System.out.println(list);
        if (list == null) {
            return new Result(201, "申请看房失败");
        } else {
            //新增合同信息
            hetongService.addHetong(hetong);
            // 申请看房
            Houselist houselist = houselistService.findHouse(Integer.parseInt(hetong.getHouse_id()));
            houselist.setStatus("申请中");
            houselistService.editHouse(houselist);
            Apply apply = new Apply();
            apply.setHouse_id(houselist.getHouseid());
            apply.setAddress(houselist.getAddress());
            apply.setApply_date(new Date());
            apply.setPrice(hetong.getPrice());
            apply.setArea(houselist.getArea());
            apply.setStatus("申请中");
            apply.setUser_id(user_id);
            applyService.addApply(apply);
            return new Result(200, "申请看房成功");
        }
    }

    /**
     * 拒绝租赁
     *
     * @param httpSession
     * @param
     * @return
     */
    @RequestMapping("/Noapply")
    public Result Noapply(HttpSession httpSession, @RequestParam("house_id") String house_id) {
        System.out.println("house_id==>" + house_id);
        // 修改 房源 状态
        Houselist houselist = houselistService.findHouse(Integer.parseInt(house_id));
        houselist.setStatus("未租赁");
        houselistService.editHouse(houselist);
        // 删除 申请 列表
        applyService.deleteByHouse_id(house_id);
        return new Result(200, "拒绝租赁成功");
    }

}
