package com.church.YPortal.dto.branch;

import com.church.YPortal.entity.BranchChurch;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchResponse {
    private UUID id;
    private String name;
    private BranchChurch.BranchType type;
    private int totalMembership;
}
