package com.example.businessapibooking.controller;

import com.example.businessapibooking.entity.Staff;
import com.example.businessapibooking.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        List<Staff> listStaff = new ArrayList<>();
        try {
            listStaff = service.findAll();
        } catch (Exception ex) {
            throw ex;
        } finally {
            LOGGER.info("getAll :" + startTime);
        }
        return new ResponseEntity<>(listStaff, HttpStatus.OK);
    }

    @RequestMapping(value = {"/findByUserRole"}, method = RequestMethod.POST)
    public ResponseEntity<?> findByUserRole(@RequestBody Integer role) {
        long startTime = System.currentTimeMillis();
        List<Staff> listStaff = new ArrayList<>();
        try {
            listStaff = service.findByUserRole(role);
        } catch (Exception ex) {
            throw ex;
        } finally {
            LOGGER.info("getAll :" + startTime);
        }
        return new ResponseEntity<>(listStaff, HttpStatus.OK);
    }
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        long startTime = System.currentTimeMillis();
        Staff staff = new Staff();
        try {
            staff = service.findById(id);
        } catch (Exception ex) {
            throw ex;
        } finally {
            LOGGER.info("getAll :" + startTime);
        }
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }
}
