package com.church.YPortal.controller;

import com.church.YPortal.dto.branch.CreateBranchRequest;
import com.church.YPortal.dto.branch.BranchResponse;
import com.church.YPortal.service.BranchChurchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/branches")
public class BranchChurchController {

    private final BranchChurchService service;

    public BranchChurchController(BranchChurchService service) {
        this.service = service;
    }

    @PostMapping
    public BranchResponse create(@RequestBody CreateBranchRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<BranchResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public BranchResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }
}
