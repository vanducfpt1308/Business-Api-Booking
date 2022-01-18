package com.example.businessapibooking.service.Impl;

import com.example.businessapibooking.dto.BookingRequest;
import com.example.businessapibooking.entity.BookingDetail;
import com.example.businessapibooking.repository.BookingDetailRepo;
import com.example.businessapibooking.repository.ServiceCustumerRepo;
import com.example.businessapibooking.repository.StaffRepository;
import com.example.businessapibooking.entity.Booking;
import com.example.businessapibooking.repository.BookingRepository;
import com.example.businessapibooking.service.BookingService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository repository;

    @Autowired
    BookingDetailRepo bookingDetailRepo;

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    ServiceCustumerRepo serviceCustumerRepo;

    @Override
    public List<Booking> findByCustomer(Integer key) {
        return repository.findByCustomer(key);
    }

    @Override
    public Booking findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Booking> findAll(List<Integer> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public Booking save(Booking obj) {
        return null;
    }

    @Override
    public List<Booking> saveAll(List<Booking> lst) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void deleteAll(List<Booking> lst) {

    }

    @Override
    public boolean existsById(Integer key) {
        return false;
    }

    @Override
    public List<Booking> findByExample(Booking e) {
        return null;
    }

    @Override
    public List<Booking> findLimit(int numberSkip, int limit) {
        return null;
    }

    @Override
    public Page<Booking> findPage(int numberSkip, int limit, List<OrderBy> orderBys) {
        return null;
    }

    @Override
    public List<Booking> findAll() {
        return null;
    }

    @Override
    public Booking create(JsonNode bookingdata) {
        ObjectMapper mapper = new ObjectMapper();
        BookingRequest bookingRequest = mapper.convertValue(bookingdata, BookingRequest.class);
        bookingRequest.setDateBooking(bookingRequest.getDateBooking() + " 07:00:00");
        Booking booking = new Booking();
        BookingDetail bookingDetail = new BookingDetail();
        booking.setCustomer(bookingRequest.getCustomer());
        repository.save(booking);
        if (bookingRequest != null) {
            bookingDetail.setBooking(booking);
            bookingDetail.setStatus(1);
            Date date = null;
            try {
                date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(bookingRequest.getDateBooking());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            bookingDetail.setFullName(bookingRequest.getCustomer().getFullName());
            bookingDetail.setEmail(bookingRequest.getCustomer().getEmail());
            bookingDetail.setPhone(bookingRequest.getCustomer().getPhone());
            bookingDetail.setDateBooking(date);
            bookingDetail.setTimeStart(bookingRequest.getTimeStart());
            bookingDetail.setTimeEnd(bookingRequest.getTimeEnd());
            bookingDetail.setNote(bookingRequest.getNote());
            bookingDetail.setStaff(bookingRequest.getStaff());
            bookingDetail.setServiceCustomer(bookingRequest.getServiceCustomer());
            bookingDetail.setDayScheduleId(bookingRequest.getDayScheduleId());
            bookingDetailRepo.save(bookingDetail);
        }
        return booking;
    }
}
