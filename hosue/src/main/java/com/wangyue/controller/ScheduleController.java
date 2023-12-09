package com.wangyue.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyue.domain.Schedule;
import com.wangyue.domain.util.Result;
import com.wangyue.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/schedulelist")
    public PageInfo<Schedule> selectAll(@RequestParam(defaultValue = "1", value = "cur") int cur,
                                        @RequestParam(defaultValue = "10", value = "size") int size) {
        PageHelper.startPage(cur, size);
        List<Schedule> schedule = scheduleService.findAll();
        PageInfo<Schedule> p = new PageInfo<>(schedule);
        System.out.println(schedule);
        return p;
    }

    /**
     * 添加日程
     *
     * @param schedule
     * @return
     */
    @RequestMapping("/insertschedule")
    public Result insertschedule(@RequestBody Schedule schedule) {
        System.out.println(schedule);
        scheduleService.addschedule(schedule);
        return new Result(200, "添加日程成功");
    }

    /**
     *  删除  日程
     * @param
     * @return
     */
    @RequestMapping("/delSchedule")
    public Result delSchedule(@RequestBody List<Integer> list) {
        System.out.println(list);
        scheduleService.delSchedule(list);
        return new Result(200, "添加日程成功");
    }

    /**
     * 修改 日程
     * @param schedule
     * @return
     */
    @RequestMapping("/editschedule")
    public Result editschedule(@RequestBody Schedule schedule) {
        System.out.println(schedule);
        scheduleService.editschedule(schedule);
        return new Result(200, "添加日程成功");
    }
}
