package com.example.businessapibooking.controller.admin;

import com.example.businessapibooking.common.ResponeCustom;
import com.example.businessapibooking.dto.ResponseDTO;
import com.example.businessapibooking.entity.ServiceCustomer;
import com.example.businessapibooking.service.ServiceCustumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth/admin")
@CrossOrigin(origins = "*")
public class ServiceCustumerController {
    @Autowired
    ServiceCustumerService custumerService;

    @GetMapping("/allservice")
    public ResponseEntity<ResponseDTO<?>> getAllService(){
        return ResponseEntity.ok(ResponseDTO.builder()
                .messageCode(ResponeCustom.MESSAGE_CODE_SUCCESS)
                .messageName(ResponeCustom.MESSAGE_NAME_SUCCESS)
                .data(custumerService.getAll())
                .build());

    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO<?>> updateService(@RequestBody ServiceCustomer serviceCustomer){

        return ResponseEntity.ok(ResponseDTO.builder()
                .messageCode(ResponeCustom.MESSAGE_CODE_SUCCESS)
                .messageName(ResponeCustom.MESSAGE_NAME_SUCCESS)
                .data(custumerService.save(serviceCustomer))
                .build());
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<?>> saveService(@RequestBody ServiceCustomer serviceCustomer){
        return ResponseEntity.ok(ResponseDTO.builder()
                .messageCode(ResponeCustom.MESSAGE_CODE_SUCCESS)
                .messageName(ResponeCustom.MESSAGE_NAME_SUCCESS)
                .data(custumerService.save(serviceCustomer))
                .build());
    }

//    @DeleteMapping("/delete/{id}")
//    private void delete(@PathVariable("id") Integer id) {
//        custumerService.deleteById(id);
//    }
}
