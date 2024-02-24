package com.DeviceRental.service;

import com.DeviceRental.model.Order;
import com.DeviceRental.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomer_Id(customerId);
    }

    public List<Order> getOrdersByDeviceId(Long deviceId) {
        return orderRepository.findByDevice_Id(deviceId);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

//    public List<Order> findByQuantityAndDeviceId(int quantity, Long deviceId) {
//        return orderRepository.findByQuantityAndDeviceId(quantity, deviceId);
//    }


    // Add more methods as needed
}
