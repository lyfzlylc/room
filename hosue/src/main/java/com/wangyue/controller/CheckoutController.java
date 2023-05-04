package com.wangyue.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyue.domain.Checkout;
import com.wangyue.domain.util.Result;
import com.wangyue.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;

    @RequestMapping("/checkout")
    public PageInfo<Checkout> selectAll(@RequestParam(defaultValue = "", value = "search") String search,
                                        @RequestParam(defaultValue = "1", value = "cur") int cur,
                                        @RequestParam(defaultValue = "10", value = "size") int size,
                                        @RequestParam(defaultValue = "", value = "username") String username
                                        ) {
        PageHelper.startPage(cur, size);
        List<Checkout> checkout = checkoutService.findAll(search,username);

        PageInfo<Checkout> p = new PageInfo<>(checkout);
        System.out.println(checkout);
        return p;
    }

    /**
     * 批量删除
     *
     * @param cur
     * @param size
     * @return
     */
    @RequestMapping("/deleteCheck")
    public Result deleteCheck(@RequestBody List<Integer> list) {
        System.out.println(list);
        checkoutService.deleteCheckout(list);
        return new Result(200, "删除成功");
    }
}
