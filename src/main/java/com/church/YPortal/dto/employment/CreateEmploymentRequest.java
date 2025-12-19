package com.church.YPortal.dto.employment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateEmploymentRequest {

    @NotBlank
    private String companyName;

    @NotBlank
    private String position;

    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;
}
