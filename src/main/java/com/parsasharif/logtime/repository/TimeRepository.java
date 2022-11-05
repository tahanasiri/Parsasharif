package com.parsasharif.logtime.repository;

import com.parsasharif.logtime.entity.TimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeRepository extends JpaRepository<TimeEntity, Long> {
    @Query(value = "select * from (select * from (select * from parsasharif.tbl_time t1 where t1.month = :month and t1.hour = (select max(t1.hour) from parsasharif.tbl_time t1)) t2 where t2.minute = (select max(t2.minute) from (select * from parsasharif.tbl_time t1 where t1.hour = (select max(t1.hour) from parsasharif.tbl_time t1)) t2)) t3 where t3.second = (select max(t3.second) from (select * from (select * from parsasharif.tbl_time t1 where t1.hour = (select max(t1.hour) from parsasharif.tbl_time t1)) t2 where t2.minute = (select max(t2.minute) from (select * from parsasharif.tbl_time t1 where t1.hour = (select max(t1.hour) from parsasharif.tbl_time t1)) t2)) t3)", nativeQuery = true)
    List<TimeEntity> findMonthByLatestTime(String month);
}
