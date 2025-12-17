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

@Service
@RequiredArgsConstructor
public class BranchChurchService {
    private final BranchChurchRepository repository;
    private final BranchChurchMapper mapper;





//    public BranchResponse create(CreateBranchRequest request) {
//        BranchChurch branch = new BranchChurch();
//        branch.setName(request.getName());
//        branch.setType(request.getType());
//        branch.setTotalMembership(0);
//
//        return mapper.toResponse(repository.save(branch));
//    }

    public BranchResponse create(CreateBranchRequest request) {
        BranchChurch branch = mapper.toEntity(request);
        return mapper.toResponse(repository.save(branch));
    }

    public List<BranchResponse> getAll() {
        return mapper.toResponseList(repository.findAll());
    }


    public BranchResponse getById(UUID id) {
        BranchChurch branch = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found"));
        return mapper.toResponse(branch);
    }

    @Transactional
    public BranchResponse update(UUID id, UpdateBranchRequest request) {
        BranchChurch branch = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Branch not found"));

        mapper.updateEntity(request, branch);

        return mapper.toResponse(repository.save(branch));
    }

    @Transactional
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Branch not found");
        }
        repository.deleteById(id);
    }
}
