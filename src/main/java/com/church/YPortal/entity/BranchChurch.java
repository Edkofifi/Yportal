package com.church.YPortal.entity;


import jakarta.persistence.*;


import java.util.UUID;

@Entity
@Table(name="branch_churches")
public class BranchChurch {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BranchType type;

    private int totalMembership;

//    @OneToMany(mappedBy = "branch")
//    private List<Member> members;
//


    public enum BranchType {
        HQ,
        LOCAL,
        MISSION
    }

}

