package com.parsasharif.logtime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RunnableService implements Runnable{
    private final TimeService timeService;

    @Autowired
    public RunnableService(TimeService timeService) {
        this.timeService = timeService;
    }


    @Override
    public void run() {
        timeService.logTime();
    }

}
