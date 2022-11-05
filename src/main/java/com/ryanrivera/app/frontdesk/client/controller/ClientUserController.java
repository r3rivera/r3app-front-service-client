package com.ryanrivera.app.frontdesk.client.controller;

import com.ryanrivera.app.frontdesk.client.feign.FeignAppServiceClient;
import com.ryanrivera.app.frontdesk.client.model.CreateUserRequest;
import com.ryanrivera.app.frontdesk.client.model.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientUserController {

    private final FeignAppServiceClient appServiceClient;

    @PostMapping("/user")
    public ResponseEntity<UserResponse> createClientUser(@RequestBody CreateUserRequest request){
        return appServiceClient.createUser(request);
    }

    @GetMapping("/user/{appUserId}")
    public ResponseEntity<UserResponse> getClientUser(@PathVariable("appUserId") UUID appUserId){
        return appServiceClient.getUser(appUserId);
    }

    @DeleteMapping("/user/{appUserId}")
    public ResponseEntity<Boolean> deleteClientUser(@PathVariable("appUserId") UUID appUserId){
        return appServiceClient.deleteUser(appUserId);
    }
}
