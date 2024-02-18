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

//    @GetMapping
//    public String getAllOrders(Model model) {
//        List<Order> orders = orderService.getAllOrders();
//        model.addAttribute("orders", orders);
//        return "order-list";
//    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return ResponseEntity.ok(orders);
    }

//    @GetMapping("/{orderId}")
//    public String getOrderById(@PathVariable Long orderId, Model model) {
//        Optional<Order> order = orderService.getOrderById(orderId);
//        model.addAttribute("order", order.orElse(null));
//        return "order-details";
//    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @GetMapping("/createOrderForm")
//    public String createOrderForm(Model model) {
//        model.addAttribute("order", new Order());
//        // Add logic to populate dropdowns or fetch devices and customers for selection
//        return "order-create";
//    }

    @GetMapping("/create")
    public String createOrderForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("devices", deviceService.getAllDevices()); // Assuming getAllDevices() fetches all devices
        model.addAttribute("customers", customerService.getAllCustomers()); // Assuming getAllCustomers() fetches all customers
        return "order-create";
    }
    //    @PostMapping("/create")
//    public String createOrder(@ModelAttribute Order order) {
//        orderService.createOrder(order);
//        return "redirect:/orders";
//    }

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



//    @GetMapping("/update/{orderId}")
//    public String updateOrderForm(@PathVariable Long orderId, Model model) {
//        Optional<Order> order = orderService.getOrderById(orderId);
//        model.addAttribute("order", order.orElse(null));
//        // Add logic to populate dropdowns or fetch devices and customers for selection
//        return "order-update";
//    }

//    @PostMapping("/update")
//    public String updateOrder(@ModelAttribute Order order) {
//        orderService.updateOrder(order);
//        return "redirect:/orders";
//    }



//    @GetMapping("/delete/{orderId}")
//    public String deleteOrder(@PathVariable Long orderId) {
//        orderService.deleteOrder(orderId);
//        return "redirect:/orders";
//    }

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

//    @GetMapping("/quantity/{quantity}/device/{deviceId}")
//    public ResponseEntity<List<Order>> getOrdersByQuantityAndDeviceId(@PathVariable int quantity, @PathVariable Long deviceId) {
//        List<Order> orders = orderService.findByQuantityAndDeviceId(quantity, deviceId);
//        if (!orders.isEmpty()) {
//            return ResponseEntity.ok(orders);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

}

