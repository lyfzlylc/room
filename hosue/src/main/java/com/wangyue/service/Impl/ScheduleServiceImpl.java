package com.wangyue.service.Impl;

import com.wangyue.domain.Schedule;
import com.wangyue.mapper.ScheduleMapper;
import com.wangyue.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Override
    public List<Schedule> findAll() {
        return scheduleMapper.findAll();
    }

    @Override
    public void addschedule(Schedule schedule) {
        scheduleMapper.addschedule(schedule);
    }

    @Override
    public void delSchedule(List<Integer> list) {
        scheduleMapper.delSchedule(list);
    }

    @Override
    public void editschedule(Schedule schedule) {
        scheduleMapper.editschedule(schedule);
    }
}
