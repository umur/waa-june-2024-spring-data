package com.waa.jpa.entities.examples.oneToOne.bi;

import jakarta.persistence.*;

@Entity
public class AddressBidirect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zip;
    private String city;

    @OneToOne(mappedBy = "address")
    private MemberBidirect member;
}
