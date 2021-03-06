package com.example.businessapibooking.service.Impl;

import com.example.businessapibooking.entity.DaySchedule;
import com.example.businessapibooking.repository.DayScheduleRepo;
import com.example.businessapibooking.service.DayScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.util.List;

@Service
public class DayScheduleServiceImpl implements DayScheduleService {
    @Autowired
    DayScheduleRepo dayScheduleRepo;

    @Override
    public List<DaySchedule> findAll() {
        return dayScheduleRepo.findAll();
    }

    @Override
    public DaySchedule findById(Integer id) {
        return dayScheduleRepo.findById(id).get();
    }

    @Override
    public List<DaySchedule> findAllById(List<Integer> ids) {
        return dayScheduleRepo.findAllById(ids);
    }

    @Override
    public DaySchedule save(DaySchedule obj) {
        return dayScheduleRepo.save(obj);
    }

    @Override
    public List<DaySchedule> saveAll(List<DaySchedule> lst) throws Exception {
        return dayScheduleRepo.saveAll(lst);
    }

    @Override
    public void delete(Integer key) {
        dayScheduleRepo.deleteById(key);
    }

    @Override
    public void deleteAll(List<DaySchedule> lst) {
        dayScheduleRepo.deleteAll(lst);
    }

    @Override
    public boolean existsById(Integer key) {
        return dayScheduleRepo.existsById(key);
    }

    @Override
    public Page<DaySchedule> findPage(int numberSkip, int limit, List<OrderBy> orderBys) {
        return null;
    }
}
