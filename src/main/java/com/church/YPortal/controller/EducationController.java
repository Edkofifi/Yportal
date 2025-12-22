package com.church.YPortal.controller;

import com.church.YPortal.dto.education.CreateEducationRequest;
import com.church.YPortal.dto.education.EducationResponse;
import com.church.YPortal.dto.member.MemberResponse;
import com.church.YPortal.service.EducationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * EducationController
 *
 * Exposes REST endpoints for managing education.
 * Delegates all business logic to EducationService.
 *
 * FLOW:
 * A. Receive HTTPS requests:
 * @RestController makes every method to automatically return JSON and not HTML
 *
 * B. Validate input
 * @Valid Tells Spring to validate the request body
 * Validation rules come from annotations inside the DTO eg @NotBlank
 * If validation fails, return bad requests
 *
 *
 * C. Delegate to service layer
 * @RequiredArgsConstructor injects Service layer object into the controller function.
 * calls service function to take over the logic.
 *
 * D. Return HTTP response
 * uses ResponseEntity<T> to control status code, response body and headers.
 */
@RestController
@RequestMapping("/api/education")
@RequiredArgsConstructor
public class EducationController {
    private final EducationService educationService;



    /**
     * Add a new education to member
     */
    @PostMapping
    public ResponseEntity<EducationResponse> createEducation(
            @Valid @RequestBody CreateEducationRequest request
            ) {
        EducationResponse response = educationService.createEducation(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    /**
     * Get all education
     */
    @GetMapping
    public ResponseEntity<List<EducationResponse>> getAll() {
        return ResponseEntity.ok(
                educationService.getAll()
        );
    }
}
