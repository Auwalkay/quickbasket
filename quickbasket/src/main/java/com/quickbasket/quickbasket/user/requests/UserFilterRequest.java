package com.quickbasket.quickbasket.user.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserFilterRequest {

    private Integer size = 20;
    private Integer page =0;
    private String search = null;
    private String role = null;
    private Integer status = null;
}
