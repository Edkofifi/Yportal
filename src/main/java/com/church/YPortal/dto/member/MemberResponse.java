package com.church.YPortal.dto.member;


import com.church.YPortal.dto.address.AddressResponse;
import com.church.YPortal.dto.education.EducationResponse;
import com.church.YPortal.dto.employment.EmploymentResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;



/**
 * MemberResponse
 *
 * This DTO represents the data sent BACK to the client
 * when fetching a Member.
 *
 * IMPORTANT:
 * - It is used only for API responses
 * - It can safely expose related data like education,
 *   employment, and addresses
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {

    private UUID id;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    /**
     * List of the member's education history
     * (e.g. schools attended, certificates)
     */
    private List<EducationResponse> educations;

    /**
     * List of the member's employment history
     * (e.g. jobs, roles, organizations)
     */
    private List<EmploymentResponse> employments;

    /**
     * List of the member's addresses
     * (e.g. home, work, previous residences)
     */
    private List<AddressResponse> addresses;
}
