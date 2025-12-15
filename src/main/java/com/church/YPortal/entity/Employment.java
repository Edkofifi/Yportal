package com.church.YPortal.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="employment")
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
