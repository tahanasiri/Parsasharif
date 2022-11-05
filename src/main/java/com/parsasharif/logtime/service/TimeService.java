package com.parsasharif.logtime.service;

import com.parsasharif.logtime.entity.TimeEntity;
import com.parsasharif.logtime.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TimeQueryService {
    private final TimeRepository timeRepository;

    @Autowired
    public TimeQueryService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Transactional
    public void logTime(){
        LocalDateTime now = LocalDateTime.now();

        TimeEntity timeEntity= new TimeEntity();
        int year = now.getYear();
        timeEntity.setYear(year/10 == 0 ? ("0"+year):String.valueOf(year));
        int month = now.getMonthValue();
        timeEntity.setMonth(month/10 == 0 ? ("0"+month):String.valueOf(month));
        int day = now.getDayOfMonth();
        timeEntity.setDay(day/10 == 0 ? ("0"+day):String.valueOf(day));
        int hour = now.getHour();
        timeEntity.setHour(hour/10 == 0 ? ("0"+hour):String.valueOf(hour));
        int minute = now.getMinute();
        timeEntity.setMinute(minute/10 == 0 ? ("0"+minute):String.valueOf(minute));
        int second = now.getSecond();
        timeEntity.setSecond(second/10 == 0 ? ("0"+second):String.valueOf(second));

        timeRepository.save(timeEntity);
    }

    @Transactional
    public String getLatestTime(String month) {
        Optional<List<TimeEntity>> timeEntityListOptional = timeRepository.findMonthByLatestTime(month);
        if (timeEntityListOptional.isPresent()) {
            try {
                List<TimeEntity> timeEntityList = timeEntityListOptional.get();
                TimeEntity timeEntity = timeEntityList.get(0);
                return timeEntity.getHour() + ":" + timeEntity.getMinute() + ":" + timeEntity.getSecond();
            }
            catch (IndexOutOfBoundsException e){
                System.out.println(e.getLocalizedMessage());
            }

        }
        throw new RuntimeException("No Log time for this month.");
    }
}
