package com.church.YPortal.controller;

import com.church.YPortal.dto.member.CreateMemberRequest;
import com.church.YPortal.dto.member.MemberResponse;
import com.church.YPortal.dto.member.UpdateMemberRequest;
import com.church.YPortal.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * MemberController
 *
 * Exposes REST endpoints for managing members.
 * Delegates all business logic to MemberService.
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
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * Create a new member
     */
    @PostMapping
    public ResponseEntity<MemberResponse> create(
            @Valid @RequestBody CreateMemberRequest request
    ) {
        MemberResponse response = memberService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Get all members
     */
    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAll() {
        return ResponseEntity.ok(
                memberService.getAll()
        );
    }

    /**
     * Get a single member by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getById(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok(
                memberService.getById(id)
        );
    }

    /**
     * Update an existing member
     */
    @PutMapping("/{id}")
    public ResponseEntity<MemberResponse> update(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateMemberRequest request
    ) {
        return ResponseEntity.ok(
                memberService.update(id, request)
        );
    }

    /**
     * Delete a member by ID
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        memberService.delete(id);
    }
}
