package com.example.businessapibooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PasswordDTO {
//    @NotEmpty(message = "Phải nhập mật khẩu cũ")
    @NotNull
    private String oldPassword;

//    @NotEmpty(message = "Phải nhập mật khẩu mới")
//    @Length(min=8, max=32, message="Mật khẩu phải dài 8-32 ký tự")
    @NotNull
    private String newPassword;

    @NotNull
    private String userName;

//    @NotEmpty(message = "Phải nhắc lại mật khẩu mới")
//    private String confirmNewPassword;
}
