package com.church.YPortal.dto.member;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor // Lombok: no-args constructor (needed for JSON deserialization)
@AllArgsConstructor
public class UpdateMemberRequest {

    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
}
