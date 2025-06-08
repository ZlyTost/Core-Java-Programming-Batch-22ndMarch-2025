package Day9;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

// Base class representing a generic smart home device
abstract class Device {
    protected String deviceId;
    protected String name;
    protected boolean powerState; // true = on, false = off
    protected LocalDateTime lastOnTime;
    protected long totalOnSeconds; // Total time device has been on for analytics

    public Device(String deviceId, String name) {
        this.deviceId = deviceId;
        this.name = name;
        this.powerState = false;
        this.totalOnSeconds = 0;
        this.lastOnTime = null;
    }

    // Turn on the device
    public void powerOn() {
        if (!powerState) {
            powerState = true;
            lastOnTime = LocalDateTime.now();
            System.out.println(name + " powered ON.");
        } else {
            System.out.println(name + " is already ON.");
        }
    }

    // Turn off the device, update usage time
    public void powerOff() {
        if (powerState) {
            powerState = false;
            long secondsOn = ChronoUnit.SECONDS.between(lastOnTime, LocalDateTime.now());
            totalOnSeconds += secondsOn;
            lastOnTime = null;
            System.out.println(name + " powered OFF after " + secondsOn + " seconds.");
        } else {
            System.out.println(name + " is already OFF.");
        }
    }

    // Abstract method to display device status with specific details
    public abstract void displayStatus();

    // Calculate total power usage in kWh assuming power rating varies by device
    public abstract double calculatePowerConsumption(); // returns kWh

    // Return uptime in seconds
    public long getTotalOnSeconds() {
        if (powerState && lastOnTime != null) {
            return totalOnSeconds + ChronoUnit.SECONDS.between(lastOnTime, LocalDateTime.now());
        }
        return totalOnSeconds;
    }

    // Display basic info and total usage time formatted as HH:mm:ss
    public void displayBasicInfo() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Name     : " + name);
        System.out.println("Power    : " + (powerState ? "ON" : "OFF"));

        long seconds = getTotalOnSeconds();
        long hrs = seconds / 3600;
        long mins = (seconds % 3600) / 60;
        long secs = seconds % 60;

        System.out.printf("Total Uptime: %02d:%02d:%02d (HH:mm:ss)%n", hrs, mins, secs);
    }
}

// Light device with brightness and color settings
class Light extends Device {
    private int brightness; // 0 to 100
    private String color;   // e.g., "Warm White", "Cool White", "Red"

    // Power rating in watts
    private static final double POWER_WATTS = 10.0;

    public Light(String deviceId, String name) {
        super(deviceId, name);
        this.brightness = 100; // default brightness
        this.color = "Warm White"; // default color
    }

    public void setBrightness(int brightness) {
        if (brightness < 0 || brightness > 100) {
            System.out.println("Invalid brightness value. Must be 0 to 100.");
            return;
        }
        this.brightness = brightness;
        System.out.println(name + " brightness set to " + brightness + "%");
    }

    public void setColor(String color) {
        this.color = color;
        System.out.println(name + " color set to " + color);
    }

    @Override
    public void displayStatus() {
        displayBasicInfo();
        System.out.println("Brightness: " + brightness + "%");
        System.out.println("Color     : " + color);
        System.out.printf("Power Consumption: %.3f kWh%n", calculatePowerConsumption());
        System.out.println("-----------------------------");
    }

    @Override
    public double calculatePowerConsumption() {
        // Power use adjusted by brightness percentage, convert watts to kW, multiply by hours of use
        double hoursOn = getTotalOnSeconds() / 3600.0;
        return POWER_WATTS * (brightness / 100.0) / 1000.0 * hoursOn;
    }
}

// Thermostat device with temperature and mode settings
class Thermostat extends Device {
    private double currentTemperature;
    private double setPointTemperature;
    private String mode; // "HEAT", "COOL", "OFF"

    // Power rating varies: HEAT mode high, COOL medium, OFF no power
    private static final double POWER_HEAT_WATTS = 3500;
    private static final double POWER_COOL_WATTS = 1500;

    public Thermostat(String deviceId, String name, double initialTemp) {
        super(deviceId, name);
        this.currentTemperature = initialTemp;
        this.setPointTemperature = initialTemp;
        this.mode = "OFF";
    }

    public void setMode(String mode) {
        List<String> allowedModes = List.of("HEAT", "COOL", "OFF");
        if (!allowedModes.contains(mode.toUpperCase())) {
            System.out.println("Invalid mode. Allowed: HEAT, COOL, OFF");
            return;
        }
        this.mode = mode.toUpperCase();
        System.out.println(name + " mode set to " + this.mode);
    }

    public void setTemperature(double temp) {
        this.setPointTemperature = temp;
        System.out.println(name + " set point temperature set to " + temp + "°C");
    }

    // Simulate temperature change over time (simplified)
    public void updateCurrentTemperature(double temp) {
        this.currentTemperature = temp;
        System.out.println(name + " current temperature updated to " + temp + "°C");
    }

    @Override
    public void displayStatus() {
        displayBasicInfo();
        System.out.println("Current Temperature  : " + currentTemperature + "°C");
        System.out.println("Set Point Temperature: " + setPointTemperature + "°C");
        System.out.println("Mode                 : " + mode);
        System.out.printf("Power Consumption    : %.3f kWh%n", calculatePowerConsumption());
        System.out.println("-----------------------------");
    }

    @Override
    public double calculatePowerConsumption() {
        double hoursOn = getTotalOnSeconds() / 3600.0;
        double powerWatts = 0.0;
        switch (mode) {
            case "HEAT": powerWatts = POWER_HEAT_WATTS; break;
            case "COOL": powerWatts = POWER_COOL_WATTS; break;
            default: powerWatts = 0; break;
        }
        return powerWatts / 1000.0 * hoursOn;
    }
}

// Security Camera device with motion detection and storage
class SecurityCamera extends Device {
    private boolean motionDetectionEnabled;
    private int storageCapacityGB;
    private int usedStorageGB;
    private List<String> alertLog;

    // Power rating fixed
    private static final double POWER_WATTS = 5.0;

    public SecurityCamera(String deviceId, String name, int storageCapacityGB) {
        super(deviceId, name);
        this.motionDetectionEnabled = true;
        this.storageCapacityGB = storageCapacityGB;
        this.usedStorageGB = 0;
        this.alertLog = new ArrayList<>();
    }

    public void enableMotionDetection() {
        motionDetectionEnabled = true;
        System.out.println(name + " motion detection enabled.");
    }

    public void disableMotionDetection() {
        motionDetectionEnabled = false;
        System.out.println(name + " motion detection disabled.");
    }

    // Simulate a motion detected event
    public void detectMotion(String area) {
        if (powerState && motionDetectionEnabled) {
            String alert = LocalDateTime.now() + ": Motion detected in " + area;
            alertLog.add(alert);
            System.out.println(name + " ALERT: " + alert);
            // Simulate storage usage growth
            usedStorageGB += 1;
            if (usedStorageGB > storageCapacityGB) {
                System.out.println(name + ": Warning! Storage full, overwriting oldest footage.");
                usedStorageGB = storageCapacityGB; // cap storage
            }
        } else {
            System.out.println(name + ": Motion detection inactive or device off.");
        }
    }

    public void clearStorage() {
        usedStorageGB = 0;
        alertLog.clear();
        System.out.println(name + ": Storage cleared.");
    }

    @Override
    public void displayStatus() {
        displayBasicInfo();
        System.out.println("Motion Detection Enabled: " + (motionDetectionEnabled ? "Yes" : "No"));
        System.out.println("Storage Capacity        : " + storageCapacityGB + " GB");
        System.out.println("Storage Used            : " + usedStorageGB + " GB");
        System.out.println("Alert Log:");
        if (alertLog.isEmpty()) {
            System.out.println("  No alerts.");
        } else {
            alertLog.stream().skip(Math.max(0, alertLog.size() - 5)).forEach(alert -> System.out.println("  " + alert));
        }
        System.out.printf("Power Consumption       : %.3f kWh%n", calculatePowerConsumption());
        System.out.println("-----------------------------");
    }

    @Override
    public double calculatePowerConsumption() {
        double hoursOn = getTotalOnSeconds() / 3600.0;
        return POWER_WATTS / 1000.0 * hoursOn;
    }
}

// Main class demonstrating smart home device management with inheritance
public class p22 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Smart Home Device Management ===\n");

        Light livingRoomLight = new Light("L001", "Living Room Light");
        Thermostat mainThermostat = new Thermostat("T001", "Main Thermostat", 24.0);
        SecurityCamera frontDoorCam = new SecurityCamera("C001", "Front Door Camera", 100);

        // Power on devices
        livingRoomLight.powerOn();
        livingRoomLight.setBrightness(75);
        livingRoomLight.setColor("Cool White");

        mainThermostat.powerOn();
        mainThermostat.setMode("HEAT");
        mainThermostat.setTemperature(22.5);

        frontDoorCam.powerOn();
        frontDoorCam.enableMotionDetection();

        // Simulate usage for approx 3 seconds (normally would be hours/days)
        Thread.sleep(3000);

        // Simulate motion detection
        frontDoorCam.detectMotion("Front Porch");
        frontDoorCam.detectMotion("Backyard");

        // Display status for all devices
        livingRoomLight.displayStatus();
        mainThermostat.displayStatus();
        frontDoorCam.displayStatus();

        // Power off some devices and show usage update
        livingRoomLight.powerOff();
        mainThermostat.powerOff();

        // Show updated usage after power off
        livingRoomLight.displayStatus();
        mainThermostat.displayStatus();

        // Clear camera storage
        frontDoorCam.clearStorage();
        frontDoorCam.displayStatus();

        // Power off camera
        frontDoorCam.powerOff();
        frontDoorCam.displayStatus();
    }
}
