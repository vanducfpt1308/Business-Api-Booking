package com.example.businessapibooking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceCustumerDTO {
    private Integer id;

    private String name;

    private String price;

    private String description;

    private MultipartFile photo;
}
