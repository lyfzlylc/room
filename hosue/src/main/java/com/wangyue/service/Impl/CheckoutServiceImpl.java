package com.wangyue.service.Impl;

import com.wangyue.domain.Checkout;
import com.wangyue.mapper.CheckoutMapper;
import com.wangyue.service.CheckoutService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private CheckoutMapper checkoutMapper;

    @Override
    public List<Checkout> findAll(String search) {
        return checkoutMapper.findAll(search);
    }

    @Override
    public void addCheckout(Checkout checkout) {
        checkoutMapper.addCheckout(checkout);
    }

    @Override
    public void deleteCheckout(List<Integer> list) {
        checkoutMapper.deleteCheckout(list);
    }


}
