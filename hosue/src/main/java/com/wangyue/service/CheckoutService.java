package com.wangyue.service;

import com.wangyue.domain.Applyout;
import com.wangyue.domain.Checkout;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckoutService {
    List<Checkout> findAll(String search);

    void addCheckout(Checkout checkout);
    void deleteCheckout(List<Integer> list);
}
