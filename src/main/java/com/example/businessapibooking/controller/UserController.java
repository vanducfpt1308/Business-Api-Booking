package com.example.businessapibooking.controller;


import com.example.businessapibooking.config.JwtTokenUtil;
import com.example.businessapibooking.dto.UserDTO;
import com.example.businessapibooking.entity.Role;
import com.example.businessapibooking.entity.Status;
import com.example.businessapibooking.entity.Users;
import com.example.businessapibooking.repository.UserRepo;
import com.example.businessapibooking.service.JwtUserDetailsService;
import com.example.businessapibooking.utils.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/auth")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepo userRepo;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDTO.getUsername(), userDTO.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getUsername());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public Status register(@RequestBody Users users) {
        try {
            users.setPassword(HashUtil.hash(users.getPassword()));
            users.setRole(new Role(2, "User", null));
            userRepo.save(users);
        } catch (Exception e) {
            System.out.println("Lỗi không register được acount!");
            e.printStackTrace();
        }
        return Status.SUCCESS;
    }
}
