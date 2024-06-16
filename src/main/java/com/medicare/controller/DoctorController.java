package com.medicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.model.DoctorModel;
import com.medicare.repository.DoctorRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DoctorController {
	
	@Autowired
	DoctorRepository docRepo;
	
	
	@GetMapping("/doctors")
	public List<DoctorModel>  GetAllDoctors(){
		List<DoctorModel> doctors = docRepo.FindAllDoctors();
		return doctors;
	}
//	
//	@GetMapping("/doctors/name/{doctorName}")
//	public List<DoctorModel>  getDoctorByName(@PathVariable String doctorName){
//		List<DoctorModel> doctors = docRepo.findByDoctorName(doctorName);
//		return doctors;
//	}
//	 
	@GetMapping("/doctors/speciality/{specialityId}")
	public List<DoctorModel> GetDoctorBySpecialityId(@PathVariable int specialityId) {
	    List<DoctorModel> doctors = docRepo.FindDoctorBySpecialityId(specialityId);
	    return doctors;
	}
	
	@GetMapping("/doctors/doctordetails/{doctorId}")
	public DoctorModel getDoctorsDetailsById(@PathVariable int doctorId) {
	    DoctorModel doctors = docRepo.findDoctorsDetailsById(doctorId);
	    return doctors;
	}
    @PostMapping("/doctors/add")
    public ResponseEntity<DoctorModel> createDoctor(@RequestBody DoctorModel doctor) {
    	System.out.println("Received Doctor: ");
//        System.out.println("Doctor_Id: " + doctor.getDoctor_Id());
//        System.out.println("Doctor_Name: " + doctor.getDoctor_Name());
//        System.out.println("Doctor_Email: " + doctor.getDoctor_Email());
        System.out.println("Doctor_Email: " + doctor.getDoctor_Experience());
        System.out.println("Doctor_Email: " + doctor.getSpeciality_Id());
        System.out.println("Doctor_Email: " + doctor.getDoctor_Clinic_Name());
        System.out.println("Doctor_Email: " + doctor.getDoctor_About());
        System.out.println("holiday: " + doctor.getDaysOff());
        docRepo.addDoctor(doctor);
		return ResponseEntity.ok(doctor);
    }

//	@GetMapping("/doctors/{id}")
//	public DoctorModel getDoctor (@PathVariable int id) {
//		DoctorModel doctors = docRepo.findById(id);
//	return doctors;
//	}
//	@PostMapping("/doctors/add")
//	public void createDoctor(
//	    @RequestParam String Doctor_Name,
//	    @RequestParam String Doctor_Email,
//	    @RequestParam String Doctor_Business_Address,
//	    @RequestParam int Doctor_Phone,
//	    @RequestParam String Doctor_Clinic_Name,
//	    @RequestParam String Doctor_Experience,
////	    @RequestParam String docSpecialityArea,
//	    @RequestParam String Doctor_About) {
//	    
//	    DoctorModel doctor = new DoctorModel(
//	    		Doctor_Name,
//	    		Doctor_Email,
//	    		Doctor_Business_Address,
//	    		Doctor_Phone,
//	    		Doctor_Clinic_Name,
//	    		Doctor_Experience,
//	    		Doctor_About
//	    );

//	    docRepo.save(doctor);
//	}



}
