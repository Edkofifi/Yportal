package com.church.YPortal.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;


import java.util.UUID;

@Entity
@Table(name="branch_churches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchChurch {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
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

