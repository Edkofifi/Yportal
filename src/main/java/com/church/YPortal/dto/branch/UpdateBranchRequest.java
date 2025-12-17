package com.church.YPortal.dto.branch;

import com.church.YPortal.entity.BranchChurch.BranchType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBranchRequest {

    @NotBlank
    private String name;

    @NotNull
    private BranchType type;

}
