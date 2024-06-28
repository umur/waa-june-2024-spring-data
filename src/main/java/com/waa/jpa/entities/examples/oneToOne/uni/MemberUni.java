package com.waa.jpa.entities.examples.oneToOne.uni;

import jakarta.persistence.*;

@Entity
public class MemberUni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String title;

    @OneToOne
    //@JoinColumn(name = "id_address") // Optional
    private AddressUni address;
}
