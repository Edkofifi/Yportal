package com.church.YPortal.dto.member;


import com.church.YPortal.dto.address.CreateAddressRequest;
import com.church.YPortal.dto.education.CreateEducationRequest;
import com.church.YPortal.dto.employment.CreateEmploymentRequest;
import com.church.YPortal.entity.BranchChurch;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * CreateMemberRequest
 *
 * This DTO represents the data coming FROM the client
 * when creating a new Member.
 *
 * IMPORTANT:
 * - This is NOT a database entity
 * - It is used only for POST /members requests
 * - Some fields are optional to allow flexible creation
 */

@Data
public class CreateMemberRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String phone;
    private String email;
    private BranchChurch church;


    /**
     * Optional list of education records
     * A member can be created without education history
     */
    private List<CreateEducationRequest> educations;

    /**
     * Optional list of employment records
     * A member can be created without employment history
     */
    private List<CreateEmploymentRequest> employments;

    /**
     * Optional list of addresses
     * Useful when capturing member details in one request
     */
    private List<CreateAddressRequest> addresses;
}
