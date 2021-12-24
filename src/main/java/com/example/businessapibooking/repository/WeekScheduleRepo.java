package com.example.businessapibooking.repository;

import com.example.businessapibooking.entity.WeekSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeekScheduleRepo extends JpaRepository<WeekSchedule, Integer> {
    List<WeekSchedule> findByStaff_Id(Integer id);
}
