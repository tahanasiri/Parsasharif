package com.parsasharif.logtime.service;

import com.parsasharif.logtime.entity.TimeEntity;
import com.parsasharif.logtime.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TimeService implements Runnable{
    private final TimeQueryService timeQueryService;


    public TimeService(TimeQueryService timeQueryService) {
        this.timeQueryService = timeQueryService;
    }

    @Autowired




    @Override
    public void run() {
        logTime();
    }



}
