package com.ryanrivera.app.frontdesk.client.model.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CommunicationType {

    PRIMARY_MOBILE("1ST_MOBILE"),
    SECONDARY_MOBILE("2ND_MOBILE"),
    PRIMARY_EMAIL("1ST_EMAIL"),
    SECONDARY_EMAIL("2ND_EMAIL");


    private String type;

    CommunicationType(String type){
        this.type = type;
    }


    @JsonValue
    private String getCommType(){
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
