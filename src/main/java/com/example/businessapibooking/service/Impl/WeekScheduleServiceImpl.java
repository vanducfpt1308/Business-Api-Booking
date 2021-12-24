package com.example.businessapibooking.service.Impl;

import com.example.businessapibooking.entity.WeekSchedule;
import com.example.businessapibooking.repository.WeekScheduleRepo;
import com.example.businessapibooking.service.WeekScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.util.List;

@Service
public class WeekScheduleServiceImpl implements WeekScheduleService {
    @Autowired
    WeekScheduleRepo weekScheduleRepo;

    @Override
    public List<WeekSchedule> findByStaffId(Integer key) {
        return weekScheduleRepo.findByStaff_Id(key);
    }

    @Override
    public WeekSchedule findById(Integer id) {
        return weekScheduleRepo.findById(id).get();
    }

    @Override
    public List<WeekSchedule> findAllById(List<Integer> ids) {
        return weekScheduleRepo.findAllById(ids);
    }

    @Override
    public WeekSchedule save(WeekSchedule obj) {
        return weekScheduleRepo.save(obj);
    }

    @Override
    public List<WeekSchedule> saveAll(List<WeekSchedule> lst) throws Exception {
        return weekScheduleRepo.saveAll(lst);
    }

    @Override
    public void delete(Integer key) {
        weekScheduleRepo.deleteById(key);
    }

    @Override
    public void deleteAll(List<WeekSchedule> lst) {
        weekScheduleRepo.deleteAll(lst);
    }

    @Override
    public boolean existsById(Integer key) {
        return weekScheduleRepo.existsById(key);
    }

    @Override
    public Page<WeekSchedule> findPage(int numberSkip, int limit, List<OrderBy> orderBys) {
        return null;
    }

    @Override
    public List<WeekSchedule> findAll() {
        return weekScheduleRepo.findAll();
    }
}
