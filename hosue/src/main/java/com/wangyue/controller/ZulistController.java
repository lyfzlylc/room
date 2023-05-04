package com.wangyue.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyue.domain.User;
import com.wangyue.domain.Zulist;
import com.wangyue.domain.util.Result;
import com.wangyue.service.ZulistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ZulistController {
    @Autowired
    private ZulistService zulistService;

    @RequestMapping("/zulist")
    public PageInfo<Zulist> selectAll(HttpSession session, @RequestParam(defaultValue = "", value = "search") String search,
                                      @RequestParam(defaultValue = "1", value = "cur") int cur,
                                      @RequestParam(defaultValue = "10", value = "size") int size, @RequestParam(defaultValue = "", value = "username") String username) {
        System.out.println("search==>" + search);
        System.out.println("username==>" + username);
        PageHelper.startPage(cur, size);
        List<Zulist> zulist;
        zulist = zulistService.findAll(search, username);

        PageInfo<Zulist> p = new PageInfo<>(zulist);
        System.out.println(p);
        return p;
    }
}
