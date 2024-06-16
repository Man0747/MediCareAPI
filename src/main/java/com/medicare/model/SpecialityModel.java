package com.medicare.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="speciality")
public class SpecialityModel {
	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Speciality_Id;
	@Column(name = "Speciality_Name")
	private String Speciality_Name;
	@Column(name = "Speciality_Description")
	private String Speciality_Description;
	
	
	public SpecialityModel(){
		
	}
	
	public SpecialityModel(int speciality_Id, String speciality_Name, String speciality_Description) {
		super();
		Speciality_Id = speciality_Id;
		Speciality_Name = speciality_Name;
		Speciality_Description = speciality_Description;
	}
	
	
	public int getSpeciality_Id() {
		return Speciality_Id;
	}
	public void setSpeciality_Id(int speciality_Id) {
		Speciality_Id = speciality_Id;
	}
	public String getSpeciality_Name() {
		return Speciality_Name;
	}
	public void setSpeciality_Name(String speciality_Name) {
		Speciality_Name = speciality_Name;
	}
	public String getSpeciality_Description() {
		return Speciality_Description;
	}
	public void setSpeciality_Description(String speciality_Description) {
		Speciality_Description = speciality_Description;
	}

}
