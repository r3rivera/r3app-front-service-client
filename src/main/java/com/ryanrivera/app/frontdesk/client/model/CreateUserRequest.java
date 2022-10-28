package com.ryanrivera.app.frontdesk.client.model;


import com.ryanrivera.app.frontdesk.client.model.domain.Address;
import com.ryanrivera.app.frontdesk.client.model.domain.ContactInfo;
import com.ryanrivera.app.frontdesk.client.model.domain.User;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class CreateUserRequest {
    private User userInfo;
    private Address address;
    private Set<ContactInfo> contactInfos;
}
