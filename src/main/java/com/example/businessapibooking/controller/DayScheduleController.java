package com.example.businessapibooking.controller;

import com.example.businessapibooking.entity.DaySchedule;
import com.example.businessapibooking.service.DayScheduleService;
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
@RequestMapping("api/day")
public class DayScheduleController {
    public static final Logger LOGGER = LoggerFactory.getLogger(DayScheduleController.class);

    @Autowired
    DayScheduleService service;

    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        long startTime = System.currentTimeMillis();
        List<DaySchedule> lst = new ArrayList<>();
        try {
            lst = service.findAll();
        } catch (Exception e) {
            throw e;
        } finally {
            LOGGER.info("getAll :" + startTime);
        }
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @RequestMapping(value = {"/findByWeek"}, method = RequestMethod.POST)
    public ResponseEntity<?> findByWeek(@RequestBody Integer id) {
        long startTime = System.currentTimeMillis();
        List<DaySchedule> lst = new ArrayList<>();
        try {
            lst = service.findByWeekScheduleIdAndStatus(id, true);
        } catch (Exception e) {
            throw e;
        } finally {
            LOGGER.info("getAll :" + startTime);
        }
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }
}
