package com.example.businessapibooking.controller;

import com.example.businessapibooking.dto.RegisterStaffRequest;
import com.example.businessapibooking.entity.Role;
import com.example.businessapibooking.entity.Staff;
import com.example.businessapibooking.entity.Users;
import com.example.businessapibooking.repository.RoleRepo;
import com.example.businessapibooking.repository.StaffRepository;
import com.example.businessapibooking.repository.UserRepo;
import com.example.businessapibooking.service.StaffService;
import com.example.businessapibooking.utils.HashUtil;
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
@RequestMapping("api/staff")
public class StaffController {
    public static final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);
    @Autowired
    StaffService service;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    StaffRepository staffRepository;

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
    @RequestMapping(value = {"/findByRole"}, method = RequestMethod.POST)
    public ResponseEntity<?> findByRole(@RequestBody Map map) {
        long startTime = System.currentTimeMillis();
        List<Staff> listStaff = new ArrayList<>();
        try {
            listStaff = service.findByRole(map);
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

    @RequestMapping(value = {"/registerDoctor"}, method = RequestMethod.POST)
    public ResponseEntity<?> registerDoctor(@RequestBody RegisterStaffRequest registerRequest) {
        long startTime = System.currentTimeMillis();
        Staff staff = new Staff();
        Role role = roleRepo.findByRole("DOCTOR");
        Users user = new Users();
        try {
            if (registerRequest != null) {
                user.setPassword(HashUtil.hash(registerRequest.getPassword()));
                user.setUsername(registerRequest.getUsername());
                user.setRole(role);
                userRepo.save(user);

                staff.setEmail(registerRequest.getEmail());
                staff.setUser(user);
                staff.setFullName(registerRequest.getFullName());
                staff.setPhoneNumber(registerRequest.getPhone());
                staff.setGender(registerRequest.getGender());
//                staff.setDateStartWork(registerRequest.getDateStartWork());
                staff.setAcademicLevel(registerRequest.getAcademicLevel());
//                staff.setDescription(registerRequest.getDescription());
                staff.setPhoto(registerRequest.getPhoto());

                staffRepository.save(staff);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            LOGGER.info("register :" + startTime);
        }
        return new ResponseEntity<>(staff,HttpStatus.OK);
    }

    @RequestMapping(value = {"/registerStaff"}, method = RequestMethod.POST)
    public ResponseEntity<?> registerStaff(@RequestBody RegisterStaffRequest registerRequest) {
        long startTime = System.currentTimeMillis();
        Staff staff = new Staff();
        Role role = roleRepo.findByRole("STAFF");
        Users user = new Users();
        try {
            if (registerRequest != null) {
                user.setPassword(HashUtil.hash(registerRequest.getPassword()));
                user.setUsername(registerRequest.getUsername());
                user.setRole(role);
                userRepo.save(user);

                staff.setEmail(registerRequest.getEmail());
                staff.setUser(user);
                staff.setFullName(registerRequest.getFullName());
                staff.setPhoneNumber(registerRequest.getPhone());
                staff.setGender(registerRequest.getGender());
//                staff.setDateStartWork(registerRequest.getDateStartWork());
                staff.setAcademicLevel(registerRequest.getAcademicLevel());
//                staff.setDescription(registerRequest.getDescription());
                staff.setPhoto(registerRequest.getPhoto());

                staffRepository.save(staff);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            LOGGER.info("register :" + startTime);
        }
        return new ResponseEntity<>(staff,HttpStatus.OK);
    }
}
