package com.medicare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "MedicalHistory")
public class MedicalHistoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MedicalHistory_Id")
    private int medicalHistory_Id;
    
    @Column(name = "MedicalHistory_Conditions")
    private String medicalHistory_Conditions;
    
    @Column(name = "MedicalHistory_Medications")
    private String medicalHistory_Medications;
    
    @Column(name = "MedicalHistory_Allergies")
    private String medicalHistory_Allergies;

    @OneToOne(mappedBy = "medicalHistory")
    private PatientModel patient;

    // Constructors
    public MedicalHistoryModel() {
    }

    public MedicalHistoryModel(String medicalHistory_Conditions, String medicalHistory_Medications, String medicalHistory_Allergies) {
        this.medicalHistory_Conditions = medicalHistory_Conditions;
        this.medicalHistory_Medications = medicalHistory_Medications;
        this.medicalHistory_Allergies = medicalHistory_Allergies;
    }

    // Getters and Setters

    public int getId() {
        return medicalHistory_Id;
    }

    public void setId(int id) {
        this.medicalHistory_Id = id;
    }

    public String getMedicalConditions() {
        return medicalHistory_Conditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalHistory_Conditions = medicalConditions;
    }

    public String getMedications() {
        return medicalHistory_Allergies;
    }

    public void setMedications(String medications) {
        this.medicalHistory_Allergies = medications;
    }

    public String getAllergies() {
        return medicalHistory_Allergies;
    }

    public void setAllergies(String allergies) {
        this.medicalHistory_Allergies = allergies;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }
}
