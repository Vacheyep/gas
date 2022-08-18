package com.example.gas.entities;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "Owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "surname",nullable = false)
    private String surname;

    @NotNull
    @Column(name = "email", unique = true,nullable = false)
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;

    public Owner(String name, String surname, String email, Address address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }
}
