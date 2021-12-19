package com.example.businessapibooking.controller;

import com.example.businessapibooking.dto.UserDTO;
import com.example.businessapibooking.service.Impl.StaffServiceImpl;
import com.example.businessapibooking.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/staff")
public class StaffController {
    public static final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);
    @Autowired
    StaffService service;

    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        long startTime = System.currentTimeMillis();

        try {
        } catch (Exception ex) {
            throw ex;
        } finally {
            LOGGER.info("getAll :" + startTime);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }


//    public @ResponseBody
//    ResponseEntity<?> getProductList(@RequestBody Map map) {
//        long startTime = System.currentTimeMillis();
//        LogUtil.showLog(logger, LogUtil.LOG_BEGIN, "getProductList", startTime);
//        MessagesResponse msg = new MessagesResponse();
//        try {
//            msg.setData(productService.getProductList(map));
//        } catch (Exception ex) {
//            logger.error(ex.getMessage(), ex);
//            throw ex;
//        } finally {
//            LogUtil.showLog(logger, LogUtil.LOG_END, "getProductList", startTime);
//        }
//        return new ResponseEntity<>(msg, HttpStatus.OK);
//    }
}
