package com.DeviceRental.controller;

import com.DeviceRental.model.Order;
import com.DeviceRental.repository.OrderRepository;
import com.DeviceRental.service.CustomerService;
import com.DeviceRental.service.DeviceService;
import com.DeviceRental.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private DeviceService deviceService;
    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



    @GetMapping("/create")
    public String createOrderForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("devices", deviceService.getAllDevices()); // Assuming getAllDevices() fetches all devices
        model.addAttribute("customers", customerService.getAllCustomers()); // Assuming getAllCustomers() fetches all customers
        return "order-create";
    }


    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order newOrder = orderRepository.save(order);
        return ResponseEntity.ok(newOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Order existingOrder = optionalOrder.get();
            existingOrder.setId(updatedOrder.getId());
            existingOrder.setId(updatedOrder.getId());
            existingOrder.setOrderDate(updatedOrder.getOrderDate());
            existingOrder.setDeliveryDate(updatedOrder.getDeliveryDate());

            Order savedOrder = orderRepository.save(existingOrder);
            return ResponseEntity.ok(savedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            orderRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/quantity/{quantity}")
    public ResponseEntity<List<Order>> getOrdersByQuantity(@PathVariable int quantity) {
        List<Order> orders = orderRepository.findByQuantity(quantity);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Order>> getOrdersByDate(@PathVariable String date) {
        List<Order> orders = orderRepository.findByOrderDate(date);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Order>> getPendingOrders() {
        List<Order> orders = orderRepository.findByStatus("Pending");
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/track/{id}")
    public ResponseEntity<String> trackOrder(@PathVariable Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.map(order -> ResponseEntity.ok("Order status: " + order.getStatus())).orElseGet(() -> ResponseEntity.notFound().build());
    }


}

