package com.DeviceRental.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="CustomerTable")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String email;
    private int mobileNo;

}
