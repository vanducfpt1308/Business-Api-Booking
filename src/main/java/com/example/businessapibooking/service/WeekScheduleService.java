package com.example.businessapibooking.service;

import com.example.businessapibooking.entity.WeekSchedule;
import org.springframework.data.domain.Page;

import javax.persistence.OrderBy;
import java.util.List;

public interface WeekScheduleService {

    List<WeekSchedule> findAll();

    WeekSchedule findById(Integer id);

    List<WeekSchedule> findByStaffId(Integer key);

    List<WeekSchedule> findAllById(List<Integer> ids);

    WeekSchedule save(WeekSchedule obj);

    List<WeekSchedule> saveAll(List<WeekSchedule> lst) throws Exception;

    void delete(Integer key);

    void deleteAll(List<WeekSchedule> lst);

    boolean existsById(Integer key);

    Page<WeekSchedule> findPage(int numberSkip, int limit, List<OrderBy> orderBys);


}
