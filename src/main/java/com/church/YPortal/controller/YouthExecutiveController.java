package com.church.YPortal.controller;


import com.church.YPortal.dto.youthExecutives.CreateExecutiveRequest;
import com.church.YPortal.dto.youthExecutives.ExecutiveResponse;
import com.church.YPortal.service.YouthExecutiveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
