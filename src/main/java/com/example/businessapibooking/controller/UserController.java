package com.example.businessapibooking.controller;


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
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        u.setToken(token);
        u.setFullName(user.getCustomer().getFullName());
        u.setUsername(user.getUsername());
        u.setRole(user.getRole().getRole());
        return ResponseEntity.ok(u);
    }

    @RequestMapping(value = {"/auth/register"}, method = RequestMethod.POST)
    public ResponseEntity<?> Register(@RequestBody RegisterRequest registerRequest) {
        long startTime = System.currentTimeMillis();
        Customer customer = new Customer();
        Role role = roleRepo.findByRole("USER");
        Users user = new Users();
        try {
            if (registerRequest != null) {
                user.setPassword(HashUtil.hash(registerRequest.getPassword()));
                user.setUsername(registerRequest.getUsername());
                user.setRole(role);
                userRepo.save(user);

                customer.setEmail(registerRequest.getEmail());
                customer.setUser(user);
                customer.setFullName(registerRequest.getFullName());
                customer.setPhone(registerRequest.getPhone());
                customerRepo.save(customer);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            LOGGER.info("register :" + startTime);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
