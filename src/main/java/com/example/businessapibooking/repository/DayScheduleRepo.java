package com.example.businessapibooking.repository;

import com.example.businessapibooking.entity.DaySchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayScheduleRepo extends JpaRepository<DaySchedule , Integer> {
    @Query(" from DaySchedule where weekSchedule.id = :weekSchedule_id and status = :status")
    List<DaySchedule> findByWeekScheduleIdAndStatus(Integer weekSchedule_id, boolean status);
}