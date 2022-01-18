package com.example.businessapibooking.controller;


import com.example.businessapibooking.dto.PasswordDTO;
import com.example.businessapibooking.dto.RegisterRequest;
import com.example.businessapibooking.entity.*;
import com.example.businessapibooking.repository.CustomerRepo;
import com.example.businessapibooking.repository.RoleRepo;
import com.example.businessapibooking.utils.HashUtil;
import com.example.businessapibooking.config.JwtTokenUtil;
import com.example.businessapibooking.dto.UserDTO;
import com.example.businessapibooking.repository.UserRepo;
import com.example.businessapibooking.service.JwtUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "*")
public class UserController {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private RoleRepo roleRepo;

    @PostMapping("auth/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDTO.getUsername(), userDTO.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getUsername());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(userDetails);
        Users user = userRepo.findByUsername(userDTO.getUsername());
        UserDTO u = new UserDTO();
        if (user.getRole().getRole().equalsIgnoreCase("user")) {
            u.setToken(token);
            u.setFullName(user.getCustomer().getFullName());
            u.setUsername(user.getUsername());
            u.setRole(user.getRole().getRole());
            u.setId(user.getCustomer().getId());
            LOGGER.info("user:" + u);
        } else {
            u.setToken(token);
            u.setRole(user.getRole().getRole());
            u.setUsername(user.getUsername());
            LOGGER.info("user:" + u);
        }
        LOGGER.info("user:" + u);
        return ResponseEntity.ok(u);
    }

    @RequestMapping(value = {"/auth/register"}, method = RequestMethod.POST)
    public ResponseEntity<?> Register(@RequestBody RegisterRequest registerRequest) {
        long startTime = System.currentTimeMillis();
        Customer customer = new Customer();
        Role role = roleRepo.findByRole("USER");
        Users user = userRepo.findByUsername(registerRequest.getUsername());
        Users u = new Users();
        if (registerRequest != null && user == null) {
            try {
                u.setPassword(HashUtil.hash(registerRequest.getPassword()));
                u.setUsername(registerRequest.getUsername());
                u.setRole(role);
                userRepo.save(u);
                customer.setEmail(registerRequest.getEmail());
                customer.setUser(u);
                customer.setFullName(registerRequest.getFullName());
                customer.setPhone(registerRequest.getPhone());
                customerRepo.save(customer);
            } catch (Exception ex) {
                throw ex;
            } finally {
                LOGGER.info("register :" + startTime);
            }
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(customer, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/auth/changePassword")
    public int changePass(@RequestBody PasswordDTO passwordDTO) {

        //Nhận vào email đang đăng nhập ở clien
        //return 1: user không tồn tại
        //return 2: pw sai
        //return 3: lưu pw mới bị lỗi
        //4: pw cũ trùng pw mới
        boolean checkPwd = false;
        Users users = userRepo.findByUsername(passwordDTO.getUserName());
        if (passwordDTO.getNewPassword().equalsIgnoreCase(passwordDTO.getOldPassword())) {
            return 4;
        } ;
        if (users == null) {
            return 1;
        } else {
            checkPwd = HashUtil.verifile(passwordDTO.getOldPassword(), users.getPassword());
            if (!checkPwd) return 2;
        }
        users.setPassword(HashUtil.hash(passwordDTO.getNewPassword()));
        try {
            userRepo.save(users);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Lưu mật khẩu không thành công !!!");
            return 3;
        }
        return 0;
    }

    @RequestMapping(value = {"/auth/locked"}, method = RequestMethod.PUT)
    public int locked(@RequestBody Users user) {
        long startTime = System.currentTimeMillis();
        try {
            userRepo.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("locked !!!");
        } finally {
            LOGGER.info("locked :" + startTime);
        }
        return 0;
    }

}
