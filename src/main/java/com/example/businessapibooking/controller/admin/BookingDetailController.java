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
public class BookingDetailController {
    @Autowired
    BookingDetailService bookingDetailService;

    //huy lich kham
    @PutMapping("/cancel/{id}")
    public ResponseEntity<ResponseDTO<?>> cancel(@PathVariable("id") Integer id) {

        BookingDetail bk = bookingDetailService.findbyId(id);
        bk.setStatus("Đã bị huỷ");
        bookingDetailService.save(bk);
        return ResponseEntity.ok(ResponseDTO.builder().messageCode("200").messageName("SUCCESS").data(bk).build());
    }
}
