package com.example.gas.entities;

import com.example.gas.entities.enums.CylinderState;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Cylinder")
public class Cylinder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "car_number",nullable = false)
    private String carNumber;

    @Column(name = "cylinder_number")
    private String cylinderNumber;

    @Column(name = "verification_date")
    private Date verificationDate;

    @Enumerated(EnumType.STRING)
    private CylinderState cylinderState;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Cylinder() {
    }

    public Cylinder(Long id, String carNumber, String cylinderNumber, Date verificationDate, Owner owner) {
        this.id = id;
        this.carNumber = carNumber;
        this.cylinderNumber = cylinderNumber;
        this.verificationDate = verificationDate;
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) { carNumber = carNumber;
    }

    public String getCylinderNumber() {
        return cylinderNumber;
    }

    public void setCylinderNumber(String cylinderNumber) {
        this.cylinderNumber = cylinderNumber;
    }

    public Date getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(Date verificationDate) {
        this.verificationDate = verificationDate;
    }
}
