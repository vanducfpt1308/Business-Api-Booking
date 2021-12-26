package com.example.businessapibooking.repository;

import com.example.businessapibooking.entity.WeekSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeekScheduleRepo extends JpaRepository<WeekSchedule, Integer> {
    @Query("from WeekSchedule w where w.staff.id = :id and w.status = :status")
    List<WeekSchedule> findByStaffIdAndStatus(Integer id, Integer status);
}
