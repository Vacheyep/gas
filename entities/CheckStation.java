package com.example.gas.entities;

import javax.persistence.*;

@Entity
@Table
public class CheckStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "special_code")
    String specialCode;

    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;


    public CheckStation() {
    }

    public CheckStation(Long id, String specialCode, Address address) {
        this.id = id;
        this.specialCode = specialCode;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialCode() {
        return specialCode;
    }

    public void setSpecialCode(String specialCode) {
        this.specialCode = specialCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
