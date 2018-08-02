package com.example.test.bus_check.showbeen;

public class HomeDeviceBeen {

    private String deviceName;
    private String deviceNum;
    private String devicelocation;

    public HomeDeviceBeen(String deviceName, String deviceNum, String devicelocation) {
        this.deviceName = deviceName;
        this.deviceNum = deviceNum;
        this.devicelocation = devicelocation;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(String deviceNum) {
        this.deviceNum = deviceNum;
    }

    public String getDevicelocation() {
        return devicelocation;
    }

    public void setDevicelocation(String devicelocation) {
        this.devicelocation = devicelocation;
    }
}
