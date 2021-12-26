package com.example.businessapibooking.controller.admin;

import com.example.businessapibooking.common.ResponeCustom;
import com.example.businessapibooking.dto.ResponseDTO;
import com.example.businessapibooking.service.CustumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth/admin")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    CustumerService custumerService;

    @GetMapping("/getAllCustomer")
    public ResponseEntity<ResponseDTO<?>> getAllCustomer(){
        return ResponseEntity.ok(ResponseDTO.builder()
                .messageCode(ResponeCustom.MESSAGE_CODE_SUCCESS)
                .messageName(ResponeCustom.MESSAGE_NAME_SUCCESS)
                .data(custumerService.findAll())
                .build());

    }
}
