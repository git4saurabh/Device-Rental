package com.DeviceRental.controller;

import com.DeviceRental.model.Order;
import com.DeviceRental.service.OrderService;
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

    @GetMapping
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "order-list";
    }

    @GetMapping("/{orderId}")
    public String getOrderById(@PathVariable Long orderId, Model model) {
        Optional<Order> order = orderService.getOrderById(orderId);
        model.addAttribute("order", order.orElse(null));
        return "order-details";
    }

    @GetMapping("/create")
    public String createOrderForm(Model model) {
        model.addAttribute("order", new Order());
        // Add logic to populate dropdowns or fetch devices and customers for selection
        return "order-create";
    }

    @PostMapping("/create")
    public String createOrder(@ModelAttribute Order order) {
        orderService.createOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/update/{orderId}")
    public String updateOrderForm(@PathVariable Long orderId, Model model) {
        Optional<Order> order = orderService.getOrderById(orderId);
        model.addAttribute("order", order.orElse(null));
        // Add logic to populate dropdowns or fetch devices and customers for selection
        return "order-update";
    }

    @PostMapping("/update")
    public String updateOrder(@ModelAttribute Order order) {
        orderService.updateOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/delete/{orderId}")
    public String deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return "redirect:/orders";
    }
}

