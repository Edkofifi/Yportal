package com.church.YPortal.dto.education;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateEducationRequest {

    @NotBlank
    private String institution;

    @NotBlank
    private String level; // e.g. SHS, Diploma, Degree

    private String course;

    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;
}
