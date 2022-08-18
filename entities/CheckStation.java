package com.example.gas.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table
public class CheckStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "special_code",nullable = false , unique = true)
    String specialCode;

    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;

    public CheckStation(String specialCode, Address address) {
        this.specialCode = specialCode;
        this.address = address;
    }
}
