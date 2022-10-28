package com.ryanrivera.app.frontdesk.client.model;

import com.ryanrivera.app.frontdesk.client.model.domain.AppUser;
import lombok.Data;

@Data
public class UserResponse {
    private AppUser user;
}

