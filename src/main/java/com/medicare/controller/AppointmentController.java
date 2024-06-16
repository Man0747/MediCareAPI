package com.medicare.controller;

import com.medicare.model.AppointmentModel;
import com.medicare.model.DoctorModel;
import com.medicare.model.PatientModel;
import com.medicare.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AppointmentController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @GetMapping("/appointments")
    public List<AppointmentModel> getAllAppointments() {
        List<AppointmentModel> appointments = appointmentRepository.findAll();
        return appointments;
    }
//
    @GetMapping("/appointments/{id}")
    public void deleteById(@PathVariable int id) {
        appointmentRepository.deleteById(id);
    }
    
    @GetMapping("/appointments/doctor/{id}/date/{appointmentDate}")
    public List<AppointmentModel> getByDateAndId(@PathVariable int id,@PathVariable Date appointmentDate) {
    	 List<AppointmentModel> appointments = appointmentRepository.findByDateAndId(id,appointmentDate);
         return appointments;
    }
    
    @PostMapping("/appointments/save")
    public void createAppointment(
            @RequestParam String appointmentDate,
            @RequestParam String appointmentTime,
            @RequestParam int appointmentFee,
            @RequestParam String appointmentNotes,
            @RequestParam int doctorId,
            @RequestParam int patientId) {

        // Parse appointmentDate and appointmentTime
        LocalDate parsedDate = LocalDate.parse(appointmentDate);
        LocalTime parsedTime = LocalTime.parse(appointmentTime, DateTimeFormatter.ofPattern("HH:mm")); // Specify the correct format

        // Combine date and time into LocalDateTime
        LocalDateTime appointmentDateTime = LocalDateTime.of(parsedDate, parsedTime);

        // Create AppointmentModel object
        AppointmentModel appointment = new AppointmentModel();
        appointment.setAppointment_Date(parsedDate);
        appointment.setAppointment_Time(appointmentDateTime); // Set the combined date and time
        appointment.setAppointment_Fee(appointmentFee);
        appointment.setAppointment_Notes(appointmentNotes);

        // Save appointment to the database along with doctorId and patientId
        appointmentRepository.save(appointment, doctorId, patientId);
    }

}
