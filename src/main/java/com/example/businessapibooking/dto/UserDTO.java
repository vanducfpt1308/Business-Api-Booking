package com.example.businessapibooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String username;
    private String password;
    private String role;
    private String token;
    private Integer id;
    private String email;
    private String photo;
    private String fullName;
    private String address;
    private Integer phone;
    private boolean isInsured;
    private String gender;
}
