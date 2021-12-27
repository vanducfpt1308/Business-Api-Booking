package com.example.businessapibooking.service.Impl;

import com.example.businessapibooking.dto.BookingDTO;
import com.example.businessapibooking.entity.BookingDetail;
import com.example.businessapibooking.entity.ServiceCustomer;
import com.example.businessapibooking.entity.Staff;
import com.example.businessapibooking.repository.BookingDetailRepo;
import com.example.businessapibooking.repository.ServiceCustumerRepo;
import com.example.businessapibooking.repository.StaffRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.example.businessapibooking.entity.Booking;
import com.example.businessapibooking.repository.BookingRepository;
import com.example.businessapibooking.service.BookingService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.util.List;
import java.util.stream.Collectors;

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
        BookingDTO bookingDTO = mapper.convertValue(bookingdata, BookingDTO.class);
        Booking booking = new Booking();
        booking.setCustomer(bookingDTO.getCustomer());
        repository.save(booking);
        if (bookingDTO != null) {
            BookingDetail bookingDetail = new BookingDetail();
            bookingDetail.setBooking(booking);
            bookingDetail.setStatus(0);
            bookingDetail.setDatebooking(bookingDTO.getDateBooking());
            bookingDetail.setTime_start(bookingDTO.getTimeStart());
            bookingDetail.setTime_end(bookingDTO.getTimeEnd());
            bookingDetail.setNote(bookingDTO.getNote());
            bookingDetail.setStaff(bookingDTO.getStaff());
            bookingDetail.setServiceCustomer(bookingDTO.getServiceCustomer());
            bookingDetailRepo.save(bookingDetail);
        }
        return booking;
    }
}
