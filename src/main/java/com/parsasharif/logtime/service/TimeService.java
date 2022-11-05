package com.parsasharif.logtime.service;

import com.parsasharif.logtime.entity.TimeEntity;
import com.parsasharif.logtime.repository.TimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TimeService {
    private final TimeRepository timeRepository;

    @Autowired
    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Transactional
    public void logTime() {
        LocalDateTime now = LocalDateTime.now();

        TimeEntity timeEntity = new TimeEntity();
        int year = now.getYear();
        timeEntity.setYear(year / 10 == 0 ? ("0" + year) : String.valueOf(year));
        int month = now.getMonthValue();
        timeEntity.setMonth(month / 10 == 0 ? ("0" + month) : String.valueOf(month));
        int day = now.getDayOfMonth();
        timeEntity.setDay(day / 10 == 0 ? ("0" + day) : String.valueOf(day));
        int hour = now.getHour();
        timeEntity.setHour(hour / 10 == 0 ? ("0" + hour) : String.valueOf(hour));
        int minute = now.getMinute();
        timeEntity.setMinute(minute / 10 == 0 ? ("0" + minute) : String.valueOf(minute));
        int second = now.getSecond();
        timeEntity.setSecond(second / 10 == 0 ? ("0" + second) : String.valueOf(second));

        timeRepository.save(timeEntity);
    }

    @Transactional
    public Object getLatestTime(List<Long> months) {
        List<String> times = new ArrayList<>();
        for (Long month : months) {
            try {
                List<TimeEntity> timeEntities = timeRepository.findMonthByLatestTime(String.valueOf(month));
                TimeEntity timeEntity = timeEntities.get(0);
                String time = timeEntity.getHour().substring(0,2) + ":" + timeEntity.getMinute() + ":" + timeEntity.getSecond();
                times.add(time);
            } catch (IndexOutOfBoundsException e) {
                times.add(null);
                System.out.println(e.getLocalizedMessage());
            }
            //throw new RuntimeException("No Log time for this month.");
        }

        HashMap<String, List<String>> map = new HashMap<>();
        map.put("expectedTimes", times);
        return map;
    }
}
