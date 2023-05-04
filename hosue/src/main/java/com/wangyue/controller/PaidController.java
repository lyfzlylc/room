package com.wangyue.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyue.domain.*;
import com.wangyue.domain.util.Result;
import com.wangyue.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class PaidController {

    @Autowired
    private ZulistService zulistService;
    @Autowired
    private TopaidService topaidService;
    @Autowired
    private PaidService paidService;
    @Autowired
    private UserlistService userlistService;
    @Autowired
    private UserService userService;

    /**
     * 收租
     *
     * @param cur
     * @param size
     * @return
     */
    @RequestMapping("/showaddpaid")
    public PageInfo<Zulist> selectAll(@RequestParam(defaultValue = "1", value = "cur") int cur,
                                      @RequestParam(defaultValue = "10", value = "size") int size) {
        PageHelper.startPage(cur, size);
        List<Zulist> zulist = zulistService.findAll("","");
        PageInfo<Zulist> p = new PageInfo<>(zulist);
        System.out.println(p);
        return p;
    }

    /**
     * 租客待缴租金
     *
     * @param cur
     * @param size
     * @return
     */
    @RequestMapping("/topaidlist")
    public Result selectAllTopaid(@RequestParam(defaultValue = "", value = "search") String search) {
        List<Topaid> topaid = topaidService.findtopaid(search);
        return new Result(200, topaid, "成功");
    }
    @RequestMapping("/topaidlistU")
    public Result topaidlistU(@RequestParam("name") String name) {
        System.out.println("name==>" + name);
        Userlist byName = userlistService.findByName(name);
        User user1 = new User();
        user1.setUsername(byName.getName());
        user1.setPassword(byName.getPassword());
        User user = userService.getUser(user1);
        List<Topaid> topaid = topaidService.findtopaidByid(user.getId());
        System.out.println(topaid);
        return new Result(200, topaid, "成功");
    }
    /**
     * 租客已缴租金
     *
     * @param cur
     * @param size
     * @return
     */
    @RequestMapping("/selectall")
    public PageInfo<Paid> selectallShi(@RequestParam(defaultValue = "", value = "search") String search,
                                       @RequestParam(defaultValue = "", value = "date") String date,
                                       @RequestParam(defaultValue = "", value = "date1") String date1,
                                       @RequestParam(defaultValue = "1", value = "cur") int cur,
                                       @RequestParam(defaultValue = "10", value = "size") int size,
                                       @RequestParam(defaultValue = "", value = "name") String name) {
        System.out.println("search==>" + search);
        System.out.println("date==>" + date);
        System.out.println("date1==>" + date1);
        System.out.println("name==>" + name);
        Userlist byName = userlistService.findByName(name);
        User user1 = new User();
        user1.setUsername(byName.getName());
        user1.setPassword(byName.getPassword());
        User user = userService.getUser(user1);

        PageHelper.startPage(cur, size);
        List<Paid> paid;
        if(user.getType().equals("房东"))
            paid = paidService.findAll(search,date,date1,0);
        else
            paid = paidService.findAll(search,date,date1,user.getId());
        PageInfo<Paid> p = new PageInfo<>(paid);
        System.out.println(p);
        return p;
    }

    /**
     * 添加收租信息
     *
     * @param topaid
     * @return
     */
    @RequestMapping("/addtopaid")
    public Result inserttopaid(HttpSession session, @RequestBody Topaid topaid) {
        System.out.println(topaid);
        // 用房屋id 在 租客代缴租金列表查询 有没有 --如果有 返回201, 租客还没有缴纳，不能再一次收租
        Topaid topaid1 = topaidService.findtopaidByHouse_id(topaid.getHouse_id());
        if (topaid1 != null)
            return new Result(201, "租客上次租金还没有缴纳,不能再一次收租");

        topaid.setName(topaid.getName());
        topaid.setUser_id(topaid.getUser_id());
        topaid.setStatus("租金未缴");
        System.out.println(topaid);
        topaidService.addtopaid(topaid);
        return new Result(200, "成功");
    }

    /**
     * 租客进行支付操作
     *
     * @param house_id
     * @return
     */
    @RequestMapping("/gotopay")
    public Result gotopay(@RequestParam("house_id") String house_id) {
        // id 找 未缴纳 对象
        Topaid topaid = topaidService.findtopaidByHouse_id(house_id);
        Paid paid = new Paid();
        paid.setHouse_id(topaid.getHouse_id());
        paid.setAddress(topaid.getAddress());
        paid.setPrice(topaid.getPrice());
        paid.setDate(topaid.getDate());
        paid.setPaydate(new Date());
        paid.setName(topaid.getName());
        paid.setUser_id(topaid.getUser_id());
        paid.setStatus("租金已缴");
        System.out.println(topaid);
        System.out.println(paid);
        // 添加 已缴纳列表
        paidService.addPaid(paid);
        // 删除 为缴纳列表
        topaidService.deletetopaid(topaid.getHouse_id());
        return new Result(200, "成功");
    }

    /**
     * 删除已缴纳列表
     *
     * @param list
     * @return
     */
    @RequestMapping("/delpaid")
    public Result delpaid(@RequestBody List<Integer> list) {
        System.out.println(list);
        paidService.deletePaid(list);
        return new Result(200, "删除成功");
    }
}
