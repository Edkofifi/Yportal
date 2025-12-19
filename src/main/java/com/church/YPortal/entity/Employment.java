package com.church.YPortal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="employment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employment {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private boolean employed;
    private String companyName;
    private String position;
    private String industry;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;
}


