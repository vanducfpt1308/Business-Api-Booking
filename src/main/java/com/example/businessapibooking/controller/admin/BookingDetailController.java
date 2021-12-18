package com.example.businessapibooking.controller.admin;

import com.example.businessapibooking.common.ResponeCustom;
import com.example.businessapibooking.dto.ResponseDTO;
import com.example.businessapibooking.entity.BookingDetail;
import com.example.businessapibooking.service.BookingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/auth/admin")
@CrossOrigin(origins = "*")
public class BookingDetailController {
    @Autowired
    BookingDetailService bookingDetailService;
    // select lich kham theo status
    @GetMapping("/allbooking")
    public ResponseEntity<ResponseDTO<?>> getAllBookingStatus(){
        return ResponseEntity.ok(ResponseDTO.builder()
                .messageCode(ResponeCustom.MESSAGE_CODE_SUCCESS)
                .messageName(ResponeCustom.MESSAGE_NAME_SUCCESS)
                .data(bookingDetailService.getAllByStatus())
                .build());

    }

    //huy lich kham
    @PutMapping("/cancel/{id}")
    public ResponseEntity<ResponseDTO<?>> cancel(@PathVariable("id") Integer id) {

        BookingDetail bk = bookingDetailService.findbyId(id);
        bk.setStatus(2);
        bookingDetailService.save(bk);
        return ResponseEntity.ok(ResponseDTO.builder()
                .messageCode(ResponeCustom.MESSAGE_CODE_SUCCESS)
                .messageName(ResponeCustom.MESSAGE_NAME_SUCCESS)
                .data(bk).build());
    }
}
