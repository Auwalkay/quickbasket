package com.quickbasket.quickbasket.Otp;

import com.quickbasket.quickbasket.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp,Long> {
    public Optional<Otp> findByEmail(String email);
}
