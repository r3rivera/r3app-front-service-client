package com.ryanrivera.app.frontdesk.client.model.domain;

import lombok.Data;

@Data
public class Address {
    private String streetName1;
    private String streetName2;
    private String city;
    private String zip;
    private String country;
}
