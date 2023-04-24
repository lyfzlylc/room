package com.wangyue.mapper;

import com.wangyue.domain.Checkout;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CheckoutMapper {
    List<Checkout> findAll(@Param("search") String search);
    void addCheckout(Checkout checkout);
    void deleteCheckout(@Param("list") List<Integer> list);
}
