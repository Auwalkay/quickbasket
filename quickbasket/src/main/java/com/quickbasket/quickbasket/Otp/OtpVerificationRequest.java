package com.quickbasket.quickbasket.Otp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OtpVerificationRequest {

    @Email(message = "Email address must be a valid address")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Otp code is required")
    private String otp;
}
