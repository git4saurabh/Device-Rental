package com.DeviceRental.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="DeviceTable")

@Data
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long deviceId;
    private String deviceName;
    private String deviceCategory;
    private String deviceProcessor;

    private double devicePrice;


    public Device() {
    }

    public Device(long deviceId, String deviceName, String deviceCategory, String deviceProcessor, double devicePrice) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceCategory = deviceCategory;
        this.deviceProcessor = deviceProcessor;
        this.devicePrice = devicePrice;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(String deviceCategory) {
        this.deviceCategory = deviceCategory;
    }

    public String getDeviceProcessor() {
        return deviceProcessor;
    }

    public void setDeviceProcessor(String deviceProcessor) {
        this.deviceProcessor = deviceProcessor;
    }

    public double getDevicePrice() {
        return devicePrice;
    }

    public void setDevicePrice(double devicePrice) {
        this.devicePrice = devicePrice;
    }
}
