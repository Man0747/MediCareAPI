package com.medicare.model;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "Patient")
public class PatientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Patient_Id")
    private int Patient_Id;

    @Column(name = "Patient_Name")
    private String Patient_Name;

    @Column(name = "Patient_DOB")
    private Date Patient_DOB;

    @Column(name = "Patient_Gender")
    private String Patient_Gender;

    @Column(name = "Patient_Address")
    private String Patient_Address;

    @Column(name = "Patient_Phone")
    private String Patient_Phone;

    @Column(name = "Patient_Email")
    private String Patient_Email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicalHistory_id", referencedColumnName = "medicalHistory_id")
    private MedicalHistoryModel medicalHistory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emergencyContact_id", referencedColumnName = "emergencyContact_id")
    private EmergencyContactModel emergencyContact;

    public PatientModel() {
        super();
    }

    public PatientModel(String patient_Name, Date patient_DOB, String patient_Gender, String patient_Address, String patient_Phone, String patient_Email, MedicalHistoryModel medicalHistory, EmergencyContactModel emergencyContact) {
        super();
        Patient_Name = patient_Name;
        Patient_DOB = patient_DOB;
        Patient_Gender = patient_Gender;
        Patient_Address = patient_Address;
        Patient_Phone = patient_Phone;
        Patient_Email = patient_Email;
        this.medicalHistory = medicalHistory;
        this.emergencyContact = emergencyContact;
    }

    // Getters and Setters

    public int getPatient_Id() {
        return Patient_Id;
    }

    public void setPatient_Id(int patient_Id) {
        Patient_Id = patient_Id;
    }

    public String getPatient_Name() {
        return Patient_Name;
    }

    public void setPatient_Name(String patient_Name) {
        Patient_Name = patient_Name;
    }

    public Date getPatient_DOB() {
        return Patient_DOB;
    }

    public void setPatient_DOB(Date patient_DOB) {
        Patient_DOB = patient_DOB;
    }

    public String getPatient_Gender() {
        return Patient_Gender;
    }

    public void setPatient_Gender(String patient_Gender) {
        Patient_Gender = patient_Gender;
    }

    public String getPatient_Address() {
        return Patient_Address;
    }

    public void setPatient_Address(String patient_Address) {
        Patient_Address = patient_Address;
    }

    public String getPatient_Phone() {
        return Patient_Phone;
    }

    public void setPatient_Phone(String patient_Phone) {
        Patient_Phone = patient_Phone;
    }

    public String getPatient_Email() {
        return Patient_Email;
    }

    public void setPatient_Email(String patient_Email) {
        Patient_Email = patient_Email;
    }

    public MedicalHistoryModel getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistoryModel medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public EmergencyContactModel getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContactModel emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}
