package com.example.businessapibooking.repository;

import com.example.businessapibooking.entity.DaySchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayScheduleRepo extends JpaRepository<DaySchedule , Integer> {
}
