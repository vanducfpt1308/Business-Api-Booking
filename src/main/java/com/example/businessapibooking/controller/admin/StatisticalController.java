package com.example.businessapibooking.controller.admin;

import com.example.businessapibooking.dto.StatisticalDTO;
import com.example.businessapibooking.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth/admin")
@CrossOrigin(origins = "*")
public class StatisticalController {
    @Autowired
    private StatisticalService statisticalService;

    //thống kê số lượng theo tháng stt = 2
    //đã xác nhận
    @GetMapping("/statistical")
    public ResponseEntity<StatisticalDTO> statisticalBooking(){
        return ResponseEntity.ok(statisticalService.countBooking());
    }

}
