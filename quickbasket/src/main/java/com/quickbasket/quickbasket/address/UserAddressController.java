package com.quickbasket.quickbasket.address;

import com.quickbasket.quickbasket.customs.response.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users/address")
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("/index")
    public ResponseEntity<ApiResponse> getUserAddresses() {
        try{

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) auth.getPrincipal();

            List<UserAddressResponse> userAddresses = userAddressService.userAddress(userDetails.getPassword());

            ApiResponse response = new ApiResponse();

            response.setMessage("Success");
            response.setData(userAddresses);
            response.setSuccess(Boolean.TRUE);

            return ResponseEntity.ok(response);

        }catch(Exception e){
            ApiResponse apiResponse = new ApiResponse(
                    false,
                    e.getMessage(),
                    null
            );

            return ResponseEntity.badRequest().body(apiResponse);
        }
    }

    @PostMapping("/store")
    public ResponseEntity<ApiResponse> storeUserAddress(@RequestBody AddUserAddressRequest userAddressRequest) {
        try{
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            String userId = userDetails.getPassword();

            UserAddressResponse userAddress =  userAddressService.storeAddress(userId,userAddressRequest);

            ApiResponse response = new ApiResponse();

            response.setMessage("Success");
            response.setData(userAddress);
            response.setSuccess(Boolean.TRUE);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse(
                    false,
                    e.getMessage(),
                    null
            );
            return ResponseEntity.badRequest().body(apiResponse);

        }
    }
}
