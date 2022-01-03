package com.example.businessapibooking.controller.admin;

import com.example.businessapibooking.common.ResponeCustom;
import com.example.businessapibooking.dto.ResponseDTO;
import com.example.businessapibooking.dto.ServiceCustumerDTO;
import com.example.businessapibooking.entity.ServiceCustomer;
import com.example.businessapibooking.service.ServiceCustumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("api/auth/admin")
@CrossOrigin(origins = "*")
public class ServiceCustumerController {
    @Autowired
    ServiceCustumerService custumerService;

    @GetMapping("/allservice")
    public ResponseEntity<ResponseDTO<?>> getAllService() {
        return ResponseEntity.ok(ResponseDTO.builder()
                .messageCode(ResponeCustom.MESSAGE_CODE_SUCCESS)
                .messageName(ResponeCustom.MESSAGE_NAME_SUCCESS)
                .data(custumerService.getAll())
                .build());

    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO<?>> updateService(@RequestBody ServiceCustomer serviceCustomer) {

        return ResponseEntity.ok(ResponseDTO.builder()
                .messageCode(ResponeCustom.MESSAGE_CODE_SUCCESS)
                .messageName(ResponeCustom.MESSAGE_NAME_SUCCESS)
                .data(custumerService.save(serviceCustomer))
                .build());
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<?>> saveService(@RequestBody ServiceCustomer serviceCustomer, HttpServletRequest request) {

        ServiceCustomer sv = custumerService.save(serviceCustomer);
        return ResponseEntity.ok(ResponseDTO.builder()
                .messageCode(ResponeCustom.MESSAGE_CODE_SUCCESS)
                .messageName(ResponeCustom.MESSAGE_NAME_SUCCESS)
                .data(sv)
                .build());
    }

    //lưu ảnh vào thư mục
    public void saveImageForService(ServiceCustomer serviceCustomer, HttpServletRequest request) {

        MultipartFile image = serviceCustomer.getPhoto();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(rootDirectory + "/resources/images/" + serviceCustomer.getId() + ".png");

        System.out.println(image != null && !image.isEmpty());
        if (image != null && !image.isEmpty()) {

            try {
                image.transferTo(new File(path.toString()));

            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException("image saving failed", ex);
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable("id") Integer id) {
        custumerService.delete(id);
    }
}
