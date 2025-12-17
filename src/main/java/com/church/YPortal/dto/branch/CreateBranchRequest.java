package com.church.YPortal.dto.branch;

import com.church.YPortal.entity.BranchChurch;
import lombok.*;

@Builder
@Getter
@Setter
public class CreateBranchRequest {
    private String name;
    private BranchChurch.BranchType type;
}
