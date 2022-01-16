package com.example.businessapibooking.repository;

import com.example.businessapibooking.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDetailRepo extends JpaRepository<BookingDetail, Integer> {
    @Query("SELECT u FROM BookingDetail u WHERE u.status = :stt")
    List<BookingDetail> findByStatus(Integer stt);

    @Query("SELECT b FROM BookingDetail b WHERE b.booking.customer.id = :id and b.status = :stt")
    List<BookingDetail> findByCustomerAndStatus(Integer id, Integer stt);

    @Query("select COUNT(id) as quantily from booking_details bk \n" +
            "where MONTH(bk.date_booking) = :month\n" +
            "and YEAR(bk.date_booking)=2021\n" +
            "and status = 2")
    Integer countBookingMonth(@Param("month") Integer month);
}
