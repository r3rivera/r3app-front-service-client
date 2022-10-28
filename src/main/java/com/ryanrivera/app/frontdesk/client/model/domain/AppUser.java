package com.ryanrivera.app.frontdesk.client.model.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class AppUser extends User{
    private UUID appUserId;
}

