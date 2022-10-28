package com.ryanrivera.app.frontdesk.client.feign;

import com.ryanrivera.app.frontdesk.client.model.CreateUserRequest;
import com.ryanrivera.app.frontdesk.client.model.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;


@FeignClient(name="frontdesk-service", url = "${frontdesk.app.service.url}")
public interface FeignAppServiceClient {

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponse> createUser(CreateUserRequest createUserRequest);

    @GetMapping(value = "/user/{appUserId}")
    ResponseEntity<UserResponse> getUser(@PathVariable("appUserId") UUID appUserId);

    @DeleteMapping(value = "/user/{appUserId}")
    ResponseEntity<Boolean> deleteUser(@PathVariable("appUserId") UUID appUserId);
}
