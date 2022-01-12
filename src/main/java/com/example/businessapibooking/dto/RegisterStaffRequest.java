package com.example.businessapibooking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterStaffRequest {
    private String username;
    private String password;
    private String email;
    private String fullName;
    private Integer phone;
    private Integer gender;
    private String workExperience;
    private String description;
    private String academicLevel;
    private Date dateStartWork;
    private String photo;
}
