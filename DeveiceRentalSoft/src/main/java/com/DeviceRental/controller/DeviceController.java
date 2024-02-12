package com.DeviceRental.controller;

import com.DeviceRental.model.Device;
import com.DeviceRental.service.DeviceService;
import org.springframework.web.bind.annotation.RequestMapping;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public String getAllDevices(Model model) {
        List<Device> devices = deviceService.getAllDevices();
        model.addAttribute("devices", devices);
        return "device-list";
    }

    @GetMapping("/{deviceId}")
    public String getDeviceById(@PathVariable Long deviceId, Model model) {
        Optional<Device> device = deviceService.getDeviceById(deviceId);
        model.addAttribute("device", device.orElse(null));
        return "device-details";
    }

    @GetMapping("/get")
    public String createDeviceForm(Model model) {
        model.addAttribute("device", new Device());
        return "device-create";
    }

    @PostMapping("/create")
    public String createDevice(@ModelAttribute Device device) {
        deviceService.createDevice(device);
        return "redirect:/devices";
    }

    @GetMapping("/update/{deviceId}")
    public String updateDeviceForm(@PathVariable Long deviceId, Model model) {
        Optional<Device> device = deviceService.getDeviceById(deviceId);
        model.addAttribute("device", device.orElse(null));
        return "device-update";
    }

    @PostMapping("/update")
    public String updateDevice(@ModelAttribute Device device) {
        deviceService.updateDevice(device);
        return "redirect:/devices";
    }

    @GetMapping("/delete/{deviceId}")
    public String deleteDevice(@PathVariable Long deviceId) {
        deviceService.deleteDevice(deviceId);
        return "redirect:/devices";
    }
}

