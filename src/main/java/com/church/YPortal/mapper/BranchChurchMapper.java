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

/**
 * BranchChurchMapper
 *
 * This interface is used by MapStruct to automatically convert
 * between:
 *  - BranchChurch entity (database object)
 *  - Request DTOs (CreateBranchRequest, UpdateBranchRequest)
 *  - Response DTO (BranchResponse)
 *
 * MapStruct will generate the implementation at build time.
 */

@Mapper(componentModel = "spring")
public interface BranchChurchMapper {

    /**
     * Converts a BranchChurch entity into a BranchResponse DTO.
     *
     * Used when sending data back to the client (API response).
     */
    BranchResponse toResponse(BranchChurch branch);


    /**
     * Converts a CreateBranchRequest DTO into a BranchChurch entity.
     *
     * Used when creating a new branch from client input.
     */
    BranchChurch toEntity(CreateBranchRequest request);


    /**
     * Updates an existing BranchChurch entity using values
     * from an UpdateBranchRequest.
     *
     * IMPORTANT:
     * - null fields in UpdateBranchRequest are ignored
     * - only non-null values will update the entity
     *
     * @MappingTarget tells MapStruct to update the existing object
     * instead of creating a new one.
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UpdateBranchRequest request,
                      @MappingTarget BranchChurch branch);

    /**
     * Converts a list of BranchChurch entities into
     * a list of BranchResponse DTOs.
     *
     * Used when returning multiple branches in an API response.
     */
    List<BranchResponse> toResponseList(List<BranchChurch> branches);
}
