package com.quickbasket.quickbasket.address;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangeStatusRequest {
    private String addressId;

    private Integer status;
}
