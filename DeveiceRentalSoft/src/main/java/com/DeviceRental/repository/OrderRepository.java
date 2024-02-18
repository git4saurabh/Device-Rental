package com.DeviceRental.repository;


import com.DeviceRental.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomer_Id(Long customerId);

    // Custom query to find orders by device
    List<Order> findByDevice_Id(Long deviceId);

//    @Query("SELECT o FROM Order o WHERE o.quantity = :quantity AND o.device.id = :deviceId")
//    List<Order> findByQuantityAndDeviceId(@Param("quantity") int quantity, @Param("deviceId") Long deviceId);


}
