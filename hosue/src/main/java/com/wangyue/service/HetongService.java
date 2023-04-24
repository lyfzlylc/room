package com.wangyue.service;

import com.wangyue.domain.Hetong;
import org.apache.ibatis.annotations.Param;

public interface HetongService {
    void addHetong(Hetong hetong);
    Hetong findhetong(String house_id);
    void delHetong(String house_id);
    void editHetong(Hetong hetong);

}
