package com.medicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.model.SpecialityModel;
import com.medicare.repository.SpecialityRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SpecialityController {
	@Autowired
	SpecialityRepository specialityRepository;
	
	@GetMapping("/speciality")
	public List<SpecialityModel>  getallSpecialities(){
		List<SpecialityModel> speciality = specialityRepository.findAll();
		return speciality;
	}
	@GetMapping("/speciality/{id}")
	public SpecialityModel getSpeciality (@PathVariable int id) {
		SpecialityModel speciality = specialityRepository.findById(id);
	return speciality;
	}
}
