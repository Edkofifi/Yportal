package com.church.YPortal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="education")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Level level;
    private boolean currentlyInSchool;
    private String institutionName;
    private String course;
    private String specialization;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;


    public enum Level {
        PRIMARY,
        JHS,
        SHS,
        DIPLOMA,
        UNDERGRADUATE,
        MASTERS,
        MPHIL,
        MBA,
        PHD
    }
}
