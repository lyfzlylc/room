package com.wangyue.controller;

import com.wangyue.domain.User;
import com.wangyue.domain.Userlist;
import com.wangyue.domain.util.Result;
import com.wangyue.domain.util.UserInfo1;
import com.wangyue.service.UserService;
import com.wangyue.service.UserlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
public class UserlistController {
    @Autowired
    private UserlistService userlistService;
    @Autowired
    private UserService userService;


    @RequestMapping("/editUserPassfd")
    public Result editUserPassfd(HttpSession session, @RequestBody UserInfo1 userInfo) {
        System.out.println(userInfo);
        User fd = (User) session.getAttribute("fd");
        Userlist userlist = new Userlist();
        if (userInfo.getPass() != "" && userInfo.getCheckPass() != "") {
            // 修改密码
            userService.editPassword(userInfo.getCheckPass(), fd.getId());
            userlist.setPassword(userInfo.getCheckPass());
            userlistService.editUser(userlist);
            return new Result(200, "修改密码成功");
        }
        return new Result(200, "修改密码成功");
    }
    @RequestMapping("/editUserPass")
    public Result editUserPass(HttpSession session, @RequestBody UserInfo1 userInfo) {
        System.out.println(userInfo);
        User user = (User) session.getAttribute("user");
        Userlist userlist = new Userlist();
        if (userInfo.getPass() != "" && userInfo.getCheckPass() != "") {
            // 修改密码
            userService.editPassword(userInfo.getCheckPass(), user.getId());
            return new Result(200, "修改密码成功");
        }
        return new Result(200, "修改密码成功");
    }

    @RequestMapping("/editUser")
    public Result editUser1(HttpSession session, @RequestBody UserInfo1 userInfo) {
        System.out.println(userInfo);
        User user = (User) session.getAttribute("user");
        Userlist userlist = userlistService.findByUserid(user.getId());
        // 修改个人信息
        if (userInfo.getPhone() != "") {
            userlist.setPhone(userInfo.getPhone());
        }
        if (userInfo.getId() != "") {
            userlist.setIdcard(userInfo.getId());
        }
        if (userInfo.getNickname() != "") {
            userlist.setNickname(userInfo.getNickname());
        }
        userlist.setUser_id(user.getId());
        userlistService.editUser(userlist);
        return new Result(200, "修改信息成功");
    }
    @RequestMapping("/editUserfd")
    public Result editUserfd(HttpSession session, @RequestBody UserInfo1 userInfo) {
        System.out.println(userInfo);
        User user = (User) session.getAttribute("fd");
        Userlist userlist = userlistService.findByUserid(user.getId());
        // 修改个人信息
        if (userInfo.getPhone() != "") {
            userlist.setPhone(userInfo.getPhone());
        }
        if (userInfo.getId() != "") {
            userlist.setIdcard(userInfo.getId());
        }
        if (userInfo.getNickname() != "") {
            userlist.setNickname(userInfo.getNickname());
        }
        userlist.setUser_id(user.getId());
        userlistService.editUser(userlist);
        return new Result(200, "修改信息成功");
    }

    @RequestMapping("/findallUser")
    public Result findallUser() {
        List<Userlist> all = userlistService.findAll();
        System.out.println(all);
        return new Result(200, all, "成功");
    }

    @RequestMapping("/getUserList")
    public Result getUserList(@RequestParam("userid") Integer userid) {
        Userlist userid1 = userlistService.findByUserid(userid);
        System.out.println(userid1);
        return new Result(200, userid1, "成功");
    }
    // super
    @RequestMapping("/addUser")
    public Result addUser(@RequestParam("name") String name, @RequestParam("pass") String pass) {
        System.out.println(name+"================="+pass);
        User user = new User();
        user.setUsername(name);
        user.setPassword(pass);
        userService.addUser(user);
        Integer id = userService.getUser(user).getId();
        user.setId(id);
        userlistService.addUser(user);
        return new Result(200, "账号添加成功");
    }

    @RequestMapping("/delUserInfo")
    public Result delUser(@RequestParam("id") Integer id) {
        System.out.println(id+"=================");
        userService.delUser(id);
        userlistService.delUser(id);
        return new Result(200, "账号删除成功");
    }
    @RequestMapping("/editUserInfo")
    public Result editUser(@RequestBody Map<String, String> map) {
        System.out.println(map.get("name"));
        System.out.println(map.get("pass"));
        System.out.println(map.get("phone"));
        System.out.println(map.get("idcard"));
        System.out.println(map.get("nickname"));
        Userlist userlist = userlistService.findByName(map.get("name"));
        System.out.println(userlist);
        return new Result(200, "账号删除成功");
    }
}
