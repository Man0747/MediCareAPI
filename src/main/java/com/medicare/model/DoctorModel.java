package com.medicare.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="doctors")
public class DoctorModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Doctor_Id")
	private int Doctor_Id;
	@Column(name = "Doctor_Name")
	private String Doctor_Name;
	@Column(name = "Doctor_Email")
	private String Doctor_Email;
	@Column(name = "Doctor_Address")
	private String Doctor_Address;
	@Column(name = "Doctor_Phone")
	private int Doctor_Phone;
	@Column(name = "Doctor_Clinic_Name")
	private String Doctor_Clinic_Name;
	@Column(name = "Doctor_Experience")
	private int Doctor_Experience;
	@Column(name = "Doctor_About")
	private String Doctor_About;
	@Column(name = "Doctor_Image_Name")
	private String Doctor_Image_Name;
	@Column(name = "Speciality_Id")
	private int Speciality_Id;
	 @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<DaysOffModel> daysOff;

	 @OneToOne(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
	 private WorkingTimeModel workingTime;
	
	

	public DoctorModel(int doctor_Id, String doctor_Name, String doctor_Email, String doctor_Address, int doctor_Phone,
			String doctor_Clinic_Name, int doctor_Experience, String doctor_About, String doctor_Image_Name,
			int speciality_Id) {
		super();
		Doctor_Id = doctor_Id;
		Doctor_Name = doctor_Name;
		Doctor_Email = doctor_Email;
		Doctor_Address = doctor_Address;
		Doctor_Phone = doctor_Phone;
		Doctor_Clinic_Name = doctor_Clinic_Name;
		Doctor_Experience = doctor_Experience;
		Doctor_About = doctor_About;
		Doctor_Image_Name = doctor_Image_Name;
		Speciality_Id = speciality_Id;
	}

	public String getDoctor_Clinic_Name() {
		return Doctor_Clinic_Name;
	}

	public void setDoctor_Clinic_Name(String doctor_Clinic_Name) {
		Doctor_Clinic_Name = doctor_Clinic_Name;
	}

	public int getDoctor_Experience() {
		return Doctor_Experience;
	}

	public void setDoctor_Experience(int doctor_Experience) {
		Doctor_Experience = doctor_Experience;
	}

	public String getDoctor_About() {
		return Doctor_About;
	}

	public void setDoctor_About(String doctor_About) {
		Doctor_About = doctor_About;
	}

	public String getDoctor_Image_Name() {
		return Doctor_Image_Name;
	}

	public void setDoctor_Image_Name(String doctor_Image_Name) {
		Doctor_Image_Name = doctor_Image_Name;
	}

	public int getSpeciality_Id() {
		return Speciality_Id;
	}

	public void setSpeciality_Id(int speciality_id) {
		Speciality_Id = speciality_id;
	}

	public List<DaysOffModel> getDaysOff() {
		return daysOff;
	}

	public void setDaysOff(List<DaysOffModel> daysOff) {
		this.daysOff = daysOff;
	}

	public WorkingTimeModel getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(WorkingTimeModel workingTime) {
		this.workingTime = workingTime;
	}

	public DoctorModel() {
	}

	

	public DoctorModel(int doctor_Id, String doctor_Name, String doctor_Email, String doctor_Address, int doctor_Phone,
			String doctor_Clinic_Name, int doctor_Experience, String doctor_About, String doctor_Image_Name,
			int speciality_Id, List<DaysOffModel> daysOff, WorkingTimeModel workingTime) {
		super();
		Doctor_Id = doctor_Id;
		Doctor_Name = doctor_Name;
		Doctor_Email = doctor_Email;
		Doctor_Address = doctor_Address;
		Doctor_Phone = doctor_Phone;
		Doctor_Clinic_Name = doctor_Clinic_Name;
		Doctor_Experience = doctor_Experience;
		Doctor_About = doctor_About;
		Doctor_Image_Name = doctor_Image_Name;
		Speciality_Id = speciality_Id;
		this.daysOff = daysOff;
		this.workingTime = workingTime;
	}

	public int getDoctor_Id() {
		return Doctor_Id;
	}

	public void setDoctor_Id(int doctor_Id) {
		Doctor_Id = doctor_Id;
	}

	public String getDoctor_Name() {
		return Doctor_Name;
	}

	public void setDoctor_Name(String doctor_Name) {
		Doctor_Name = doctor_Name;
	}

	public String getDoctor_Email() {
		return Doctor_Email;
	}

	public void setDoctor_Email(String doctor_Email) {
		Doctor_Email = doctor_Email;
	}

	public String getDoctor_Address() {
		return Doctor_Address;
	}

	public void setDoctor_Address(String doctor_Address) {
		Doctor_Address = doctor_Address;
	}

	public int getDoctor_Phone() {
		return Doctor_Phone;
	}

	public void setDoctor_Phone(int doctor_Phone) {
		Doctor_Phone = doctor_Phone;
	}	

}