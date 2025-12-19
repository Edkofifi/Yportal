package com.church.YPortal.dto.address;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateAddressRequest {

    @NotBlank
    private String country;

    @NotBlank
    private String region;

    @NotBlank
    private String city;

    private String street;
    private String houseNumber;
}
