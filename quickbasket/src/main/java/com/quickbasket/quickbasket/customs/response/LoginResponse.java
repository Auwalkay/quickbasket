package com.quickbasket.quickbasket.customs.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {

    private String token;
    private String email;
    private Integer status;
    private String id;
    private String name;
}
