package com.example.businessapibooking.service.Impl;

import com.example.businessapibooking.entity.BookingDetail;
import com.example.businessapibooking.entity.DaySchedule;
import com.example.businessapibooking.repository.BookingDetailRepo;
import com.example.businessapibooking.service.BookingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BookingDetailServiceImpl implements BookingDetailService {
    @Autowired
    BookingDetailRepo bookingDetailRepo;

    @Override
    public List<BookingDetail> findByCustomerAndStatus(Map map) {
        List<BookingDetail> lst = new ArrayList<>();
        if (map != null) {
            Integer id = (Integer) map.get("CUSTOMER");
            Integer status = (Integer) map.get("STATUS");
            lst = bookingDetailRepo.findByCustomerAndStatus(id, status);
        }
        return lst;
    }

    @Override
    public BookingDetail findbyId(Integer id) {
        return bookingDetailRepo.findById(id).get();
    }

    @Override
    public BookingDetail save(BookingDetail bookingDetail) {
        return bookingDetailRepo.save(bookingDetail);
    }

    @Override
    public List<BookingDetail> getAllByStatus(Integer stt) {
        return bookingDetailRepo.findByStatus(stt);
    }
}
