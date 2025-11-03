package com.quickbasket.quickbasket.role;

import com.quickbasket.quickbasket.customs.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/all")
    private ResponseEntity<ApiResponse> all() {
        ApiResponse response = new ApiResponse();

        response.setMessage("All roles retrieved successfully");

        response.setSuccess(Boolean.TRUE);

        response.setData(roleService.findAll());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
