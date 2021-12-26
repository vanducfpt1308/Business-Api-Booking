package com.example.businessapibooking.controller;

import com.example.businessapibooking.entity.Staff;
import com.example.businessapibooking.entity.WeekSchedule;
import com.example.businessapibooking.service.WeekScheduleService;
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
@RequestMapping("api/week")
public class WeekScheduleController {
    public static final Logger LOGGER = LoggerFactory.getLogger(WeekScheduleController.class);

    @Autowired
    WeekScheduleService service;

    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        long startTime = System.currentTimeMillis();
        List<WeekSchedule> lst = new ArrayList<>();
        try {
            lst = service.findAll();
        } catch (Exception e) {
            throw e;
        } finally {
            LOGGER.info("getAll :" + startTime);
        }
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @RequestMapping(value = {"/findByStaffIdAndStatus"}, method = RequestMethod.POST)
    public ResponseEntity<?> findByStaff(@RequestBody  Map map) {
        long startTime = System.currentTimeMillis();
        List<WeekSchedule> lst = new ArrayList<>();
        try {
            lst = service.findByStaffIdAndStatus(map);
        } catch (Exception e) {
            throw e;
        } finally {
            LOGGER.info("getAll :" + startTime);
        }
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }
}
