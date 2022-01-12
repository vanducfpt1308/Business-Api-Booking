package com.example.businessapibooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PasswordDTO {
    @NotEmpty(message = "Phải nhập mật khẩu cũ")
    private String oldPassword;

    @NotEmpty(message = "Phải nhập mật khẩu mới")
    @Length(min=8, max=32, message="Mật khẩu phải dài 8-32 ký tự")
    private String newPassword;

    @NotEmpty(message = "Phải nhắc lại mật khẩu mới")
    private String confirmNewPassword;
}
