package com.example.gas.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table
public class CheckStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "special_code",nullable = false , unique = true)
    private String specialCode;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public CheckStation(String specialCode, Address address) {
        this.specialCode = specialCode;
        this.address = address;
    }

    public CheckStation() {

    }
}
