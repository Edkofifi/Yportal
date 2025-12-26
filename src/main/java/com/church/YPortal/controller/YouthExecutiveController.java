package com.church.YPortal.controller;


import com.church.YPortal.dto.youthExecutives.CreateExecutiveRequest;
import com.church.YPortal.dto.youthExecutives.ExecutiveResponse;
import com.church.YPortal.service.YouthExecutiveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/youth-executives")
@RequiredArgsConstructor
public class YouthExecutiveController {
    private final YouthExecutiveService youthExecutiveService;

    @PostMapping
    private ResponseEntity<ExecutiveResponse> createYouthExecutive(
            @Valid @RequestBody CreateExecutiveRequest createExecutiveRequest
            ){
        ExecutiveResponse executiveResponse = youthExecutiveService.createYouthExecutive(createExecutiveRequest);
        return new ResponseEntity<>(executiveResponse, HttpStatus.CREATED);
    }



    /**
     * Get all executives
     */
    @GetMapping
    public ResponseEntity<List<ExecutiveResponse>> getAllYouthExecutives(){
        return ResponseEntity.ok(
                youthExecutiveService.getAllExecutives()
        );
    }

    /**
     * delete an executive
     */
    @DeleteMapping("/{id}")
    public void deleteYouthExecutive(
            @PathVariable UUID id){
        youthExecutiveService.deleteYouthExecutive(id);
    }




}
