package com.church.YPortal.service;


import com.church.YPortal.dto.branch.BranchResponse;
import com.church.YPortal.dto.branch.CreateBranchRequest;
import com.church.YPortal.dto.branch.UpdateBranchRequest;
import com.church.YPortal.entity.BranchChurch;
import com.church.YPortal.mapper.BranchChurchMapper;
import com.church.YPortal.repository.BranchChurchRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


/**
 * BranchChurchService
 *
 * This service contains the BUSINESS LOGIC related to BranchChurch.
 * Controllers should call this service instead of talking
 * directly to the repository.
 */
@Service
@RequiredArgsConstructor
public class BranchChurchService {
    // Repository handles database operations (CRUD)
    private final BranchChurchRepository branchChurchRepository;

    // Mapper converts between Entity <-> DTOs
    private final BranchChurchMapper mapper;


//    public BranchResponse create(CreateBranchRequest request) {
//        BranchChurch branch = new BranchChurch();
//        branch.setName(request.getName());
//        branch.setType(request.getType());
//        branch.setTotalMembership(0);
//
//        return mapper.toResponse(repository.save(branch));
//    }
    /**
     * Creates a new BranchChurch.
     *
     * Flow:
     * 1. Convert CreateBranchRequest DTO to BranchChurch entity
     * 2. Save entity to database
     * 3. Convert saved entity to BranchResponse DTO
     */
    public BranchResponse create(CreateBranchRequest request) {

        // Convert request DTO into entity
        BranchChurch branch = mapper.toEntity(request);

        // Save entity and convert to response DTO
        return mapper.toResponse(
                branchChurchRepository.save(branch)
        );
    }

    /**
     * Fetches all branches from the database.
     *
     * @return list of BranchResponse DTOs
     */
    public List<BranchResponse> getAll() {

        // Fetch all entities and map them to response DTOs
        return mapper.toResponseList(
                branchChurchRepository.findAll()
        );
    }


    /**
     * Fetches a single branch by its ID.
     *
     * @param id UUID of the branch
     * @throws RuntimeException if branch is not found
     */
    public BranchResponse getById(UUID id) {

        // Find branch or throw error if not found
        BranchChurch branch = branchChurchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        // Convert entity to response DTO
        return mapper.toResponse(branch);
    }

    /**
     * Updates an existing branch.
     * - Only non-null fields from UpdateBranchRequest will be updated
     * - This is handled by MapStruct in the mapper
     */
    @Transactional
    public BranchResponse update(UUID id, UpdateBranchRequest request) {

        // Fetch existing entity
        BranchChurch branch = branchChurchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Branch not found"));

        // Update entity fields using mapper (null values are ignored)
        mapper.updateEntity(request, branch);

        // Save updated entity and return response
        return mapper.toResponse(
                branchChurchRepository.save(branch)
        );
    }

    /**
     * Deletes a branch by ID.
     *
     * @throws EntityNotFoundException if branch does not exist
     */
    @Transactional
    public void delete(UUID id) {

        // Check if branch exists before deleting
        if (!branchChurchRepository.existsById(id)) {
            throw new EntityNotFoundException("Branch not found");
        }

        // Delete branch from database
        branchChurchRepository.deleteById(id);
    }
}
