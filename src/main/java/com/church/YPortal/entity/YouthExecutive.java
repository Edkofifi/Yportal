package com.church.YPortal.entity;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name= "youth_executives")
public class YouthExecutive {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;


    @Enumerated(EnumType.STRING)
    private Position position;

    public enum Position {
        YouthLeader,
        AssistantYouthLeader,
        Secretary
    }
}
