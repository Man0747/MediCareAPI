package com.medicare.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class AppointmentModel {
	
  	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Appointment_Id")
    private int Appointment_Id;

    @Column(name = "Appointment_Date")
    private LocalDate Appointment_Date;

    @Column(name = "Appointment_Time")
    private LocalDateTime Appointment_Time;

    @Column(name = "Appointment_Fee")
    private int Appointment_Fee;

    @Column(name = "Appointment_Notes", length = 500)
    private String Appointment_Notes;

    @ManyToOne
    @JoinColumn(name = "Doctor_Id")
    private DoctorModel doctor;

    @ManyToOne
    @JoinColumn(name = "Patient_Id")
    private PatientModel patient;
        
	public AppointmentModel() {
		
	}

	public AppointmentModel(int appointment_Id, LocalDate date, LocalDateTime timestamp,
			int appointment_Fee, String appointment_Notes, DoctorModel doctor, PatientModel i) {
		
		Appointment_Id = appointment_Id;
		Appointment_Date = date;
		Appointment_Time = timestamp;
		Appointment_Fee = appointment_Fee;
		Appointment_Notes = appointment_Notes;
		this.doctor = doctor;
		this.patient = i;
	}

	

	public int getAppointment_Id() {
		return Appointment_Id;
	}

	public void setAppointment_Id(int appointment_Id) {
		Appointment_Id = appointment_Id;
	}

	public LocalDate getAppointment_Date() {
		return Appointment_Date;
	}

	public void setAppointment_Date(LocalDate appointment_Date) {
		Appointment_Date = appointment_Date;
	}

	public LocalDateTime getAppointment_Time() {
		return Appointment_Time;
	}

	public void setAppointment_Time(LocalDateTime appointment_Time) {
		Appointment_Time = appointment_Time;
	}

	public int getAppointment_Fee() {
		return Appointment_Fee;
	}

	public void setAppointment_Fee(int appointment_Fee) {
		Appointment_Fee = appointment_Fee;
	}

	public String getAppointment_Notes() {
		return Appointment_Notes;
	}

	public void setAppointment_Notes(String appointment_Notes) {
		Appointment_Notes = appointment_Notes;
	}

	public DoctorModel getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorModel doctor) {
		this.doctor = doctor;
	}

	public PatientModel getPatient() {
		return patient;
	}

	public void setPatient(PatientModel patient) {
		this.patient = patient;
	}
		
	
	  

	    
	}

