package com.example.businessapibooking.controller.admin;

import com.example.businessapibooking.common.ResponeCustom;
import com.example.businessapibooking.dto.ActionReceive;
import com.example.businessapibooking.dto.ResponseDTO;
import com.example.businessapibooking.dto.SearchDTO;
import com.example.businessapibooking.entity.BookingDetail;
import com.example.businessapibooking.entity.DaySchedule;
import com.example.businessapibooking.entity.Staff;
import com.example.businessapibooking.service.BookingDetailService;
import com.example.businessapibooking.service.DayScheduleService;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/auth/admin")
public class BookingDetailController {
    public static final Logger LOGGER = LoggerFactory.getLogger(BookingDetailController.class);
    @Autowired
    BookingDetailService bookingDetailService;

    @Autowired
    DayScheduleService dayScheduleService;

    // select lich kham stt
    @GetMapping("/allbooking/{stt}")
    public ResponseEntity<ResponseDTO<?>> getAllBookingStatus(@PathVariable("stt") Integer stt) {
        return ResponseEntity.ok(ResponseDTO.builder()
                .messageCode(ResponeCustom.MESSAGE_CODE_SUCCESS)
                .messageName(ResponeCustom.MESSAGE_NAME_SUCCESS)
                .data(bookingDetailService.getAllByStatus(stt))
                .build());
    }

    @RequestMapping(value = {"/findByCustomer"}, method = RequestMethod.POST)
    public ResponseEntity<?> findById(@RequestBody Map map) {
        long startTime = System.currentTimeMillis();
        List<BookingDetail> lst = new ArrayList<>();
        try {
            lst = bookingDetailService.findByCustomerAndStatus(map);
        } catch (Exception ex) {
            throw ex;
        } finally {
            LOGGER.info("getAll :" + startTime);
        }
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @RequestMapping(value = {"/searchByDate"}, method = RequestMethod.POST)
    public ResponseEntity<?> findByDateBookingAndStatus(@RequestBody SearchDTO value) {
        long startTime = System.currentTimeMillis();
        List<BookingDetail> lst = new ArrayList<>();
        try {
            lst = bookingDetailService.findByDateBookingAndStatus(value);
        } catch (Exception ex) {
            throw ex;
        } finally {
            LOGGER.info("getAll :" + startTime);
        }
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @RequestMapping(value = {"/updateBookingDetail"}, method = RequestMethod.PUT)
    public ResponseEntity<?> updateBookingDetail(@RequestBody BookingDetail detail) {
        long startTime = System.currentTimeMillis();
        BookingDetail obj = new BookingDetail();

        try {
            LOGGER.info("update :" + detail);
            obj = bookingDetailService.save(detail);
        } catch (Exception ex) {
            throw ex;
        } finally {
            LOGGER.info("getAll :" + startTime);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = {"/updateStatus"}, method = RequestMethod.PUT)
    public ResponseEntity<?> updateStatus(@RequestBody ActionReceive action) {
        long startTime = System.currentTimeMillis();
        BookingDetail obj = action.getBookingDetail();
        obj.setStatus(action.getStatus());
        try {

            obj = bookingDetailService.save(obj);
        } catch (Exception ex) {
            throw ex;
        } finally {
            LOGGER.info("getAll :" + startTime);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = {"/searchByDoctor"}, method = RequestMethod.POST)
    public ResponseEntity<?> searchByDateBooking(@RequestBody Map map) {
        long startTime = System.currentTimeMillis();
        List<BookingDetail> lst = new ArrayList<>();
        try {
            lst = bookingDetailService.findByDoctorAndStatus(map);
        } catch (Exception ex) {
            throw ex;
        } finally {
            LOGGER.info("getAll :" + startTime);
        }
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @PutMapping("/confirm")
    public ResponseEntity<ResponseDTO<?>> confirmBooking(@RequestBody BookingDetail detail) {
        detail.setStatus(2);
        DaySchedule daySchedule = dayScheduleService.findById(detail.getDayScheduleId());
        daySchedule.setStatus(0);
        dayScheduleService.save(daySchedule);
        bookingDetailService.save(detail);
        return ResponseEntity.ok(ResponseDTO.builder()
                .messageCode(ResponeCustom.MESSAGE_CODE_SUCCESS)
                .messageName(ResponeCustom.MESSAGE_NAME_SUCCESS)
                .data(detail).build());
    }

    //huy lich kham
    @PutMapping("/cancel/{id}")
    public ResponseEntity<ResponseDTO<?>> cancel(@PathVariable("id") Integer id) {

        BookingDetail bk = bookingDetailService.findbyId(id);
        bk.setStatus(3);
        bookingDetailService.save(bk);
        return ResponseEntity.ok(ResponseDTO.builder()
                .messageCode(ResponeCustom.MESSAGE_CODE_SUCCESS)
                .messageName(ResponeCustom.MESSAGE_NAME_SUCCESS)
                .data(bk).build());
    }
}
