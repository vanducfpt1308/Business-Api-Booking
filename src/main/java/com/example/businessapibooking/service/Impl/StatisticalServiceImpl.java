package com.example.businessapibooking.service.Impl;

import com.example.businessapibooking.dto.StatisticalDTO;
import com.example.businessapibooking.repository.BookingDetailRepo;
import com.example.businessapibooking.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticalServiceImpl implements StatisticalService {
    @Autowired
    BookingDetailRepo bookingDetailRepo;


    @Override
    public StatisticalDTO countBooking() {
        StatisticalDTO dto = new StatisticalDTO();
        dto.setThang1(bookingDetailRepo.countBookingMonth(1));
        dto.setThang2(bookingDetailRepo.countBookingMonth(2));
        dto.setThang3(bookingDetailRepo.countBookingMonth(3));
        dto.setThang4(bookingDetailRepo.countBookingMonth(4));
        dto.setThang5(bookingDetailRepo.countBookingMonth(5));
        dto.setThang6(bookingDetailRepo.countBookingMonth(6));
        dto.setThang7(bookingDetailRepo.countBookingMonth(7));
        dto.setThang8(bookingDetailRepo.countBookingMonth(8));
        dto.setThang9(bookingDetailRepo.countBookingMonth(9));
        dto.setThang10(bookingDetailRepo.countBookingMonth(10));
        dto.setThang11(bookingDetailRepo.countBookingMonth(11));
        dto.setThang12(bookingDetailRepo.countBookingMonth(12));
        return dto;
    }

    @Override
    public StatisticalDTO countCancelBooking() {
        StatisticalDTO dto = new StatisticalDTO();
        dto.setThang1(bookingDetailRepo.countCancelBookingMonth(1));
        dto.setThang2(bookingDetailRepo.countCancelBookingMonth(2));
        dto.setThang3(bookingDetailRepo.countCancelBookingMonth(3));
        dto.setThang4(bookingDetailRepo.countCancelBookingMonth(4));
        dto.setThang5(bookingDetailRepo.countCancelBookingMonth(5));
        dto.setThang6(bookingDetailRepo.countCancelBookingMonth(6));
        dto.setThang7(bookingDetailRepo.countCancelBookingMonth(7));
        dto.setThang8(bookingDetailRepo.countCancelBookingMonth(8));
        dto.setThang9(bookingDetailRepo.countCancelBookingMonth(9));
        dto.setThang10(bookingDetailRepo.countCancelBookingMonth(10));
        dto.setThang11(bookingDetailRepo.countCancelBookingMonth(11));
        dto.setThang12(bookingDetailRepo.countCancelBookingMonth(12));
        return dto;
    }
}
