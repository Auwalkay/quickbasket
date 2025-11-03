package com.quickbasket.quickbasket.address;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddUserAddressRequest {

    private String street;    // nullable
    private String city;      // nullable
    private String state;     // nullable
    private String address;   // nullable

    @NotNull(message = "Longitude is required")
    private String longitude;

    @NotNull(message = "Latitude is required")
    private String latitude;

    private Integer status = 100;
}
