package com.example.businessapibooking.repository;

import com.example.businessapibooking.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDetailRepo extends JpaRepository<BookingDetail,Integer> {
     @Query("SELECT u FROM BookingDetail u WHERE u.status = 1")
     List<BookingDetail> findByStatus();

}
