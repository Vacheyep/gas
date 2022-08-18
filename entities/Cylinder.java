package com.example.gas.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "Cylinder")
public class Cylinder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "car_number",nullable = false,unique = true)
    private String carNumber;

    @Column(name = "cylinder_number",nullable = false,unique = true)
    private String cylinderNumber;

    @Column(name = "verification_date",nullable = false)
    private Date verificationDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;



    public Cylinder(String carNumber, String cylinderNumber, Date verificationDate, Owner owner) {
        this.carNumber = carNumber;
        this.cylinderNumber = cylinderNumber;
        this.verificationDate = verificationDate;
        this.owner = owner;
    }
}
