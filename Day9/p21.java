package Day9;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

// Base Patient class representing generic patient information
abstract class Patient {
    protected String patientId;
    protected String name;
    protected int age;
    protected String gender;
    protected List<String> medicalHistory;

    public Patient(String patientId, String name, int age, String gender) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.medicalHistory = new ArrayList<>();
    }

    // Add medical history record
    public void addMedicalHistory(String record) {
        medicalHistory.add(record);
    }

    // Abstract method to calculate billing amount
    public abstract double calculateBill();

    // Abstract method to display patient details
    public abstract void displayDetails();

    // General info display
    protected void displayBasicInfo() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name      : " + name);
        System.out.println("Age       : " + age);
        System.out.println("Gender    : " + gender);
        System.out.println("Medical History:");
        if (medicalHistory.isEmpty()) {
            System.out.println("  No records.");
        } else {
            for (String record : medicalHistory) {
                System.out.println("  - " + record);
            }
        }
    }
}

// Outpatient subclass representing patients with appointments
class Outpatient extends Patient {
    private LocalDate appointmentDate;
    private double consultationFee;
    private boolean followUpRecommended;
    private double followUpFee;

    public Outpatient(String patientId, String name, int age, String gender,
                      LocalDate appointmentDate, double consultationFee) {
        super(patientId, name, age, gender);
        this.appointmentDate = appointmentDate;
        this.consultationFee = consultationFee;
        this.followUpRecommended = false;
        this.followUpFee = 0.0;
    }

    public void recommendFollowUp(double fee) {
        followUpRecommended = true;
        followUpFee = fee;
    }

    @Override
    public double calculateBill() {
        double bill = consultationFee;
        if (followUpRecommended) {
            bill += followUpFee;
        }
        return bill;
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Outpatient Details ===");
        displayBasicInfo();
        System.out.println("Appointment Date     : " + appointmentDate);
        System.out.printf("Consultation Fee     : ₹%.2f%n", consultationFee);
        if (followUpRecommended) {
            System.out.printf("Follow-up Recommended: Yes (Fee ₹%.2f)%n", followUpFee);
        } else {
            System.out.println("Follow-up Recommended: No");
        }
        System.out.printf("Total Bill           : ₹%.2f%n", calculateBill());
        System.out.println("---------------------------");
    }
}

// Inpatient subclass representing patients admitted in hospital
class Inpatient extends Patient {
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private double dailyRoomCharge;
    private double medicinesCharge;
    private double procedureCharge;

    public Inpatient(String patientId, String name, int age, String gender,
                     LocalDate admissionDate, double dailyRoomCharge) {
        super(patientId, name, age, gender);
        this.admissionDate = admissionDate;
        this.dischargeDate = null;  // Not discharged yet
        this.dailyRoomCharge = dailyRoomCharge;
        this.medicinesCharge = 0.0;
        this.procedureCharge = 0.0;
    }

    public void addMedicinesCharge(double amount) {
        medicinesCharge += amount;
    }

    public void addProcedureCharge(double amount) {
        procedureCharge += amount;
    }

    public void dischargePatient(LocalDate dischargeDate) {
        if (dischargeDate.isBefore(admissionDate)) {
            throw new IllegalArgumentException("Discharge date cannot be before admission date");
        }
        this.dischargeDate = dischargeDate;
    }

    public int getStayDuration() {
        if (dischargeDate == null) {
            return (int) ChronoUnit.DAYS.between(admissionDate, LocalDate.now());
        } else {
            return (int) ChronoUnit.DAYS.between(admissionDate, dischargeDate);
        }
    }

    @Override
    public double calculateBill() {
        int stayDays = getStayDuration();
        double stayCharge = stayDays * dailyRoomCharge;
        return stayCharge + medicinesCharge + procedureCharge;
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Inpatient Details ===");
        displayBasicInfo();
        System.out.println("Admission Date     : " + admissionDate);
        System.out.println("Discharge Date     : " + (dischargeDate == null ? "Not discharged yet" : dischargeDate));
        System.out.println("Stay Duration      : " + getStayDuration() + " days");
        System.out.printf("Daily Room Charge  : ₹%.2f%n", dailyRoomCharge);
        System.out.printf("Medicines Charge   : ₹%.2f%n", medicinesCharge);
        System.out.printf("Procedure Charge   : ₹%.2f%n", procedureCharge);
        System.out.printf("Total Bill         : ₹%.2f%n", calculateBill());
        System.out.println("---------------------------");
    }
}

// EmergencyPatient subclass representing emergency cases
class EmergencyPatient extends Patient {
    private LocalDate arrivalDateTime;
    private String criticalConditionDescription;
    private double emergencyCharge;
    private double surgeryCharge;

    public EmergencyPatient(String patientId, String name, int age, String gender,
                            LocalDate arrivalDateTime, String criticalConditionDescription) {
        super(patientId, name, age, gender);
        this.arrivalDateTime = arrivalDateTime;
        this.criticalConditionDescription = criticalConditionDescription;
        this.emergencyCharge = 0.0;
        this.surgeryCharge = 0.0;
    }

    public void addEmergencyCharge(double amount) {
        emergencyCharge += amount;
    }

    public void addSurgeryCharge(double amount) {
        surgeryCharge += amount;
    }

    @Override
    public double calculateBill() {
        return emergencyCharge + surgeryCharge;
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Emergency Patient Details ===");
        displayBasicInfo();
        System.out.println("Arrival Date & Time      : " + arrivalDateTime);
        System.out.println("Critical Condition       : " + criticalConditionDescription);
        System.out.printf("Emergency Charges        : ₹%.2f%n", emergencyCharge);
        System.out.printf("Surgery Charges          : ₹%.2f%n", surgeryCharge);
        System.out.printf("Total Bill               : ₹%.2f%n", calculateBill());
        System.out.println("---------------------------");
    }
}

// Main class demonstrating Healthcare Patient Records
public class p21 {
    public static void main(String[] args) {
        System.out.println("=== Healthcare Patient Records System ===\n");

        // Outpatient example
        Outpatient op = new Outpatient("P001", "Alice Green", 30, "Female",
                                       LocalDate.of(2024, 7, 15), 500.0);
        op.addMedicalHistory("Allergic to penicillin");
        op.addMedicalHistory("Asthma since 2010");
        op.recommendFollowUp(200.0);
        op.displayDetails();

        System.out.println();

        // Inpatient example
        Inpatient ip = new Inpatient("P002", "Bob White", 60, "Male",
                                     LocalDate.of(2024, 6, 20), 2000.0);
        ip.addMedicalHistory("Diabetes");
        ip.addMedicinesCharge(8000.0);
        ip.addProcedureCharge(15000.0);
        ip.dischargePatient(LocalDate.of(2024, 7, 5));
        ip.displayDetails();

        System.out.println();

        // Emergency patient example
        EmergencyPatient ep = new EmergencyPatient("P003", "Carol Black", 45, "Female",
                                                   LocalDate.of(2024, 7, 10),
                                                   "Severe cardiac arrest");
        ep.addMedicalHistory("Hypertension");
        ep.addEmergencyCharge(12000.0);
        ep.addSurgeryCharge(50000.0);
        ep.displayDetails();
    }
}
