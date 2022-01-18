package com.example.businessapibooking.repository;

import com.example.businessapibooking.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingDetailRepo extends JpaRepository<BookingDetail, Integer> {
    @Query("SELECT u FROM BookingDetail u WHERE u.status = :stt")
    List<BookingDetail> findByStatus(Integer stt);

    @Query("SELECT b FROM BookingDetail b WHERE b.booking.customer.id = :id and b.status = :stt")
    List<BookingDetail> findByCustomerAndStatus(Integer id, Integer stt);

    @Query("SELECT b FROM BookingDetail b WHERE b.dateBooking = :date and b.status = :stt")
    List<BookingDetail> findByDateBookingAndStatus(Date date, Integer stt);

    @Query("SELECT b FROM BookingDetail b WHERE b.staff.id = :id and b.status = :stt")
    List<BookingDetail> findByDoctor(Integer id, Integer stt);

    @Query("SELECT COUNT(bk.id) from BookingDetail bk where MONTH(bk.dateBooking) = :month\n" +
            "and YEAR(bk.dateBooking)=2021\n" +
            "and bk.status = 2")
    public Integer countBookingMonth(@Param("month") Integer month);

    @Query("SELECT COUNT(bk.id) from BookingDetail bk where MONTH(bk.dateBooking) = :month\n" +
            "and YEAR(bk.dateBooking)=2021\n" +
            "and bk.status = 3")
    public Integer countCancelBookingMonth(@Param("month") Integer month);
}
