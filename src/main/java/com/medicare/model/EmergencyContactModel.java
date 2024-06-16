package com.medicare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "EmergencyContact")
public class EmergencyContactModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmergencyContact_Id")
    private int emergencyContact_Id;
    
    @Column(name = "EmergencyContact_Name")
    private String emergencyContact_Name;
    
    @Column(name = "EmergencyContact_Relationship")
    private String emergencyContact_Relationship;
    
    @Column(name = "EmergencyContact_Phone")
    private String emergencyContact_Phone;

    @OneToOne(mappedBy = "emergencyContact")
    private PatientModel patient;

    // Constructors
    public EmergencyContactModel() {
    }

    public EmergencyContactModel(String emergencyContact_Name, String emergencyContact_Relationship, String emergencyContact_Phone, PatientModel patient) {
        this.emergencyContact_Name = emergencyContact_Name;
        this.emergencyContact_Relationship = emergencyContact_Relationship;
        this.emergencyContact_Phone = emergencyContact_Phone;
        this.patient = patient;
    }

    // Getters and Setters

    public int getId() {
        return emergencyContact_Id;
    }

    public void setId(int id) {
        this.emergencyContact_Id = id;
    }

    public String getContactName() {
        return emergencyContact_Name;
    }

    public void setContactName(String contactName) {
        this.emergencyContact_Name = contactName;
    }

    public String getContactRelationship() {
        return emergencyContact_Name;
    }

    public void setContactRelationship(String contactRelationship) {
        this.emergencyContact_Name = contactRelationship;
    }

    public String getContactPhone() {
        return emergencyContact_Phone;
    }

    public void setContactPhone(String contactPhone) {
        this.emergencyContact_Phone = contactPhone;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }
}
