package com.church.YPortal.dto.education;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class EducationResponse {

    private UUID id;
    private String institution;
    private String level;
    private String course;
    private LocalDate startDate;
    private LocalDate endDate;
}