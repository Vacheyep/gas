package com.example.gas.model.entities;


import com.example.gas.model.entities.enums.Role;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "password")
    private String Password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
