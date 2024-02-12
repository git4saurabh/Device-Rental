package com.DeviceRental.service;

import com.DeviceRental.model.Device;
import com.DeviceRental.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Optional<Device> getDeviceById(Long deviceId) {
        return deviceRepository.findById(deviceId);
    }

    public List<Device> getDevicesByCategory(String category) {
        return deviceRepository.findByCategory(category);
    }

    public List<Device> getDevicesByProcessor(String processor) {
        return deviceRepository.findByProcessor(processor);
    }

    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device updateDevice(Device device) {
        return deviceRepository.save(device);
    }

    public void deleteDevice(Long deviceId) {
        deviceRepository.deleteById(deviceId);
    }
}
