package com.wangyue.mapper;

import com.wangyue.domain.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    List<Schedule> findAll();
    void addschedule(Schedule schedule);
    void delSchedule(List<Integer> list);
    void editschedule(Schedule schedule);
}
