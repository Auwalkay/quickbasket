package com.quickbasket.quickbasket.address;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAddressResponse {
    private String street;    // nullable
    private String city;      // nullable
    private String state;     // nullable
    private String address;   // nullable
    private String longitude;
    private String latitude;
    private Integer status;
    private String userId;
    private String id;

    public UserAddressResponse(UserAddress userAddress) {
        this.street = userAddress.getStreet();
        this.city = userAddress.getCity();
        this.state = userAddress.getState();
        this.address = userAddress.getAddress();
        this.longitude = userAddress.getLongitude();
        this.latitude = userAddress.getLatitude();
        this.status = userAddress.getStatus();
        this.id = userAddress.getId();
        if (userAddress.getUser() != null) {
            this.userId = userAddress.getUser().getId();
        }
    }
}
