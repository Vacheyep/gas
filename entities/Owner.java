package com.example.gas.entities;


import javax.persistence.*;

@Entity
@Table(name = "Owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String Name;

    @Column(name = "surname")
    private String Surname;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;

    public Owner() {
    }

    public Owner(Long id, String name, String surname, String email, Address address) {
        this.id = id;
        Name = name;
        Surname = surname;
        this.email = email;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
