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
    private int quantity;
    private String status;

    private LocalDateTime deliveryDate;

    private double totalPrice;

    public Order() {
    }

    public Order(long id, Customer customer, Device device, LocalDateTime orderDate, LocalDateTime deliveryDate, double totalPrice) {
        this.id = id;
        this.customer = customer;
        this.device = device;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }



    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


}
