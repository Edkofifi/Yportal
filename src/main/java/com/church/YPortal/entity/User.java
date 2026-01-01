package com.church.YPortal.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @Column(unique = true, nullable = false)
        private String email;

        @Column(nullable = false)
        private String password;   // will hash it

        @Enumerated(EnumType.STRING)
        private Role role;

        private boolean enabled = true;

        @OneToOne
        @JoinColumn(name = "member_id", nullable = true)
        private Member member;

    public enum Role {
        ADMIN,
        ZONAL_EXECUTIVE,
        BRANCH_EXECUTIVE,
    }

}



