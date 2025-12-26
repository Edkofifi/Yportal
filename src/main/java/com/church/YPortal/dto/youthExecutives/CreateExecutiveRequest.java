package com.church.YPortal.dto.youthExecutives;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateExecutiveRequest {

    @NotNull
    private UUID memberId;

    @NotNull
    private String position;

}
