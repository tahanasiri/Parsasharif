package com.parsasharif.logtime.controller;

import com.parsasharif.logtime.dto.TimeDefinition;
import com.parsasharif.logtime.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/logTime")
public class timeController {
    private final TimeService timeService;
    private final TaskScheduler taskScheduler;

    @Autowired
    public timeController(TimeService timeService, TaskScheduler taskScheduler) {
        this.timeService = timeService;
        this.taskScheduler = taskScheduler;
    }



    @PostMapping
    public void logTime(@RequestBody TimeDefinition timeDefinition){
        taskScheduler.schedule(timeService, new CronTrigger(timeDefinition.getCronExpression()));
    }
}
