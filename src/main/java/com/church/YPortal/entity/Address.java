package com.church.YPortal.entity;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String street;
    private String city;
    private String state;
    private String country;
}
