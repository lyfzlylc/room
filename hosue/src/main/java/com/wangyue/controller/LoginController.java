package com.wangyue.controller;

import com.wangyue.domain.User;
import com.wangyue.domain.Userlist;
import com.wangyue.domain.util.Result;
import com.wangyue.domain.util.UserInfo;
import com.wangyue.service.UserService;
import com.wangyue.service.UserlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserlistService userlistService;

    /**
     * 登录 请求
     *
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public Result Login(HttpServletRequest request, @RequestBody User user) {
        System.out.println(user);
        User user1 = userService.getUser(user);
        System.out.println("登录信息==>" + user1);

        Userlist userlist = userlistService.findByUserid(user1.getId());
        System.out.println("登录人信息==>" + userlist);

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(user.getUsername());
        userInfo.setPassword(user.getPassword());
        userInfo.setType(user.getType());
        userInfo.setIdcard(userlist.getIdcard());
        userInfo.setPhone(userlist.getPhone());
        userInfo.setUser_id(userlist.getUser_id());
        userInfo.setNickname(userlist.getNickname());
        System.out.println(userInfo);
        if (user1 == null)
            return new Result(201, "登录失败");
        if (user.getType().equals("房东"))
            request.getSession().setAttribute("fd", user1);
        else
            request.getSession().setAttribute("user", user1);
        String token = UUID.randomUUID().toString();
        return new Result(200, userInfo, "登录成功", token);
    }
    @RequestMapping("/slogin")
    public Result Login1(HttpServletRequest request, @RequestBody User user) {
        System.out.println(user);
        User user1 = userService.getUser(user);
        System.out.println("登录信息==>" + user1);
        if (user1 == null)
            return new Result(201, "登录失败");
        request.getSession().setAttribute("user", user1);
        String token = UUID.randomUUID().toString();
        return new Result(200, user1, "登录成功", token);
    }
    /**
     * 注册
     *
     * @param
     * @param
     * @param
     * @return
     */
    @RequestMapping("/register")
    public Result register(@RequestBody Map<String, String> map) {
        System.out.println(map.get("username"));
        System.out.println(map.get("password"));
        System.out.println(map.get("confirmPassword"));
        if (!map.get("password").equals(map.get("confirmPassword")))
            return new Result(201, "注册失败");
        //  注册成功
        User user = new User();
        user.setUsername(map.get("username"));
        user.setPassword(map.get("password"));
        userService.addUser(user);
        Integer id = userService.getUser(user).getId();
        user.setId(id);
        userlistService.addUser(user);
        return new Result(200, map, "注册成功");
    }

    @RequestMapping("/end")
    public Result End(HttpServletRequest request, @RequestParam("type") String type) {
        System.out.println("type==>" + type);
        if (type.equals("房东"))
            request.getSession().removeAttribute("admin");
        else
            request.getSession().removeAttribute("user");
        return new Result(200, "退出成功");
    }
}
