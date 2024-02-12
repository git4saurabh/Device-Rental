package com.DeviceRental.repository;

import com.DeviceRental.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    // Custom query to find devices by category
    List<Device> findByCategory(String category);

    // Custom query to find devices by processor
    List<Device> findByProcessor(String processor);
}
