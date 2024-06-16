package com.medicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.model.DoctorModel;
import com.medicare.model.PatientModel;
import com.medicare.repository.PatientRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PatientController {
	@Autowired
	PatientRepository patientRepository;
	
	 @PostMapping("/patient/add")
	    public ResponseEntity<PatientModel> CreatePatient(@RequestBody PatientModel patient) {
	        patientRepository.addPatient(patient);
			return ResponseEntity.ok(patient);
	    }
}
