package com.wangyue.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyue.domain.*;
import com.wangyue.domain.util.Result;
import com.wangyue.service.SolveService;
import com.wangyue.service.UserService;
import com.wangyue.service.UserlistService;
import com.wangyue.service.WrongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class WrongController {
    @Autowired
    private WrongService wrongService;
    @Autowired
    private SolveService solveService;
    @Autowired
    private UserlistService userlistService;
    @Autowired
    private UserService userService;


    @RequestMapping("/wronglist")
    public Result selectAll(HttpSession session, @RequestParam("name") String name) {
        System.out.println("name==>" + name);
        Userlist byName = userlistService.findByName(name);
        User user1 = new User();
        user1.setUsername(byName.getName());
        user1.setPassword(byName.getPassword());
        User user = userService.getUser(user1);

        List<Wrong> wrong;
        if (user.getType().equals("房东"))
            wrong = wrongService.findAll("");
        else
            wrong = wrongService.findAll(user.getId()+"");
        System.out.println(wrong);
        return new Result(200, wrong, "成功");
    }

    /**
     * 添加 报障
     *
     * @param wrong
     * @return
     */
    @RequestMapping("/addwrong")
    public Result addwrong(@RequestBody Wrong wrong) {
        System.out.println("wrong==>" + wrong);
        wrong.setStatus("待处理");
        wrongService.addWrong(wrong);
        return new Result(200, wrong, "报障成功");
    }

    /**
     * 处理报障
     *
     * @param id
     * @return
     */
    @RequestMapping("/handleWrong")
    public Result handleWrong(@RequestParam("id") String id) {
        // 通过 id 查 未处理报障 对象
        Wrong wrong = wrongService.findWrongByid(id);
        System.out.println("wrong==>" + wrong);
        // 创建 已处理报障 对象
        Solve solve = new Solve();
        solve.setHouse_id(wrong.getHouse_id());
        solve.setAddress(wrong.getAddress());
        solve.setDate(wrong.getDate());
        solve.setDetail(wrong.getDetail());
        solve.setName(wrong.getName());
        solve.setUser_id(wrong.getUser_id());
        solve.setStatus("已处理");
        System.out.println("solve==>" + solve);
        // 添加 已处理 列表
        solveService.addSolve(solve);
        // 删除未处理报障
        wrongService.delWrong(Integer.valueOf(id));
        return new Result(200, "处理报障成功");
    }
}
