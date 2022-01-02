package com.example.businessapibooking.service;

import com.example.businessapibooking.entity.DaySchedule;
import com.example.businessapibooking.repository.DayScheduleRepo;
import org.springframework.data.domain.Page;

import javax.persistence.OrderBy;
import java.util.List;
import java.util.Map;

public interface DayScheduleService {
    List<DaySchedule> findAll();

    List<DaySchedule> findByWeekScheduleIdAndStatus(Integer id, boolean status);

    List<DaySchedule> findByStaffAndWeekSchedule(Map map);

    DaySchedule findById(Integer id);

    List<DaySchedule> findAllById(List<Integer> ids);

    DaySchedule save(DaySchedule obj);

    List<DaySchedule> saveAll(List<DaySchedule> lst) throws Exception;

    void delete(Integer key);

    void deleteAll(List<DaySchedule> lst);

    boolean existsById(Integer key);

    Page<DaySchedule> findPage(int numberSkip, int limit, List<OrderBy> orderBys);
}
