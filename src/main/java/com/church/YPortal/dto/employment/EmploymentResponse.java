package com.church.YPortal.dto.employment;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class EmploymentResponse {

    private UUID id;
    private String companyName;
    private String position;
    private LocalDate startDate;
    private LocalDate endDate;
}
