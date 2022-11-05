package com.parsasharif.logtime.controller;

import com.parsasharif.logtime.dto.MonthObject;
import com.parsasharif.logtime.dto.TimeDefinition;
import com.parsasharif.logtime.service.TimeService;
import com.parsasharif.logtime.service.RunnableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api")
public class TimeController {
    private final TimeService timeService;
    private final RunnableService runnableService;
    private final ThreadPoolTaskScheduler taskScheduler;

    @Autowired
    public TimeController(TimeService timeService, RunnableService runnableService, ThreadPoolTaskScheduler taskScheduler) {
        this.timeService = timeService;
        this.runnableService = runnableService;
        this.taskScheduler = taskScheduler;
    }

    @PostMapping("/logCurrentTime")
    public void logCurrentTime(){
        timeService.logTime();
    }


    @PostMapping("/logScheduledTime")
    public void logScheduledTime(@RequestBody TimeDefinition timeDefinition){
        taskScheduler.schedule(runnableService, new CronTrigger(timeDefinition.getCronExpression()));
    }

    @GetMapping("/latestTime")
    public Object getLatestTime(@RequestBody MonthObject months){
        return timeService.getLatestTime(months.getMonths());
    }
}
