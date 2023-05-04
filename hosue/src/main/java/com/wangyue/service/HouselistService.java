package com.wangyue.service;

import com.wangyue.domain.Houselist;

import java.util.List;

public interface HouselistService {
    List<Houselist> selectAll(String search,String select);
    void addHouse(Houselist housel);
    void editHouse(Houselist housel);
    void deleteHouse(List<Integer> list);
    Houselist findHouse(int houseid);
}
