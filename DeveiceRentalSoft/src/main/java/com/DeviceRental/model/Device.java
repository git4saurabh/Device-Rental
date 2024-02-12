package com.DeviceRental.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="DeviceTable")

@Data
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String category;
    private String processor;

    private double devicePrice;



}
