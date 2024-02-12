package com.DeviceRental.model;

import lombok.Data;

import javax.persistence.*;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name="OrderTable")

public class Order {

    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Device device;
    private LocalDateTime orderDate;

    private LocalDateTime deliveryDate;

    private double totalPrice;
}
