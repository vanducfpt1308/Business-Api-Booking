package com.example.businessapibooking.controller.admin;

import com.example.businessapibooking.common.ResponeCustom;
import com.example.businessapibooking.dto.ResponseDTO;
import com.example.businessapibooking.entity.BookingDetail;
import com.example.businessapibooking.entity.Staff;
import com.example.businessapibooking.service.BookingDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/auth/admin")
@CrossOrigin(origins = "*")
public class BookingDetailController {
    public static final Logger LOGGER = LoggerFactory.getLogger(BookingDetailController.class);
    @Autowired
    BookingDetailService bookingDetailService;

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

    @PutMapping("/confirm")
    public ResponseEntity<ResponseDTO<?>> confirmBooking(@RequestBody BookingDetail id) {
        id.setStatus(2);
        bookingDetailService.save(id);
        return ResponseEntity.ok(ResponseDTO.builder()
                .messageCode(ResponeCustom.MESSAGE_CODE_SUCCESS)
                .messageName(ResponeCustom.MESSAGE_NAME_SUCCESS)
                .data(id).build());
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
