package com.quickbasket.quickbasket.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserAddressRepository extends JpaRepository<UserAddress,String> {
    public List<UserAddress> findByUser_Id(String userId);

    @Query("SELECT ua FROM UserAddress ua WHERE ua.user.id = :userId AND ua.status = 200")
    public UserAddress findActiveUserAddress(@Param("userId") String userId);
}
