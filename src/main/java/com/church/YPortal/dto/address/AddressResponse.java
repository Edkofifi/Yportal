package com.church.YPortal.dto.address;

import lombok.Data;

import java.util.UUID;

@Data
public class AddressResponse {

    private UUID id;
    private String country;
    private String region;
    private String city;
    private String street;
    private String houseNumber;
}
