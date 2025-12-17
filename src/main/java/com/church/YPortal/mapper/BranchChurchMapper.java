package com.church.YPortal.mapper;

import com.church.YPortal.dto.branch.BranchResponse;
import com.church.YPortal.dto.branch.CreateBranchRequest;
import com.church.YPortal.dto.branch.UpdateBranchRequest;
import com.church.YPortal.entity.BranchChurch;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BranchChurchMapper {
    BranchResponse toResponse(BranchChurch branch);

    BranchChurch toEntity(CreateBranchRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UpdateBranchRequest request,
                      @MappingTarget BranchChurch branch);

    List<BranchResponse> toResponseList(List<BranchChurch> branches);
}
