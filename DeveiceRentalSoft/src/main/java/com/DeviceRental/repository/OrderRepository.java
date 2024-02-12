package com.DeviceRental.repository;


import com.DeviceRental.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomer_Id(Long customerId);

    // Custom query to find orders by device
    List<Order> findByDevice_Id(Long deviceId);

}
