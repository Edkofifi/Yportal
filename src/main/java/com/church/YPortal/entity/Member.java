package com.church.YPortal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;

    private String phone;
    private String email;

    private boolean abroad; // true if living outside country
    private String countryOfResidence;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private BranchChurch branch;

//    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
//    private Education education;
//
//    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
//    private Employment employment;

//    @ManyToMany
//    @JoinTable(
//            name = "member_church_roles",
//            joinColumns = @JoinColumn(name = "member_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<ChurchRole> churchRoles = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "permanent_address_id")
    private Address permanentAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "temporary_address_id")
    private Address temporaryAddress;

    public enum ChurchRole{
        USHERING,
        CHOIR,
        SANITATION,
        SUNDAY_SCHOOL,
        MEDIA,
    }
}
