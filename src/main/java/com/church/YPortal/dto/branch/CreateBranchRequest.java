package com.church.YPortal.dto.branch;

import com.church.YPortal.entity.BranchChurch;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
public class CreateBranchRequest {

    @NotNull
    private String name;

    @NotNull
    private BranchChurch.BranchType type;
}
