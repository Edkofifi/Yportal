package com.church.YPortal.dto.education;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CreateEducationRequest {

    @NotNull
    private UUID memberId;

    @NotBlank
    private String institution;

    @NotBlank
    private String level; // e.g. SHS, Diploma, Degree

    private String course;

    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;
}
