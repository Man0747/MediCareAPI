package com.medicare.repository;

import com.medicare.model.AppointmentModel;
import com.medicare.model.DoctorModel;
import com.medicare.model.PatientModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class AppointmentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<AppointmentModel> findAll() {
		return null;
//        return jdbcTemplate.query("SELECT a.*, d.Doctor_Name,d.doctor_business_address,d.doctor_image_name,p.Patient_Name \r\n"
//        		+ "FROM appointments a \r\n"
//        		+ "LEFT JOIN doctors d ON a.Doctor_Id = d.Doctor_Id LEFT JOIN patient p ON a.Patient_Id = p.Patient_Id\r\n", (rs, rowNum) ->
//        new AppointmentModel(
//                rs.getInt("Appointment_Id"),
//                rs.getDate("Appointment_Date").toLocalDate(),
//                rs.getTimestamp("Appointment_Time").toLocalDateTime(),
//                rs.getInt("Appointment_Fee"),
//                rs.getString("Appointment_Notes"),
//                new DoctorModel(
//                        rs.getInt("Doctor_Id"), // Assuming DoctorModel constructor requires ID and Name
//                        rs.getString("Doctor_Name"),
//                        rs.getString("Doctor_Business_Address"),
//                        rs.getString("Doctor_Image_Name")
//                )
////                new PatientModel(
////                		 rs.getInt("Patient_Id"),
////                		 rs.getString("Patient_Name")
////                )
////                
//               
//        ));
    }
    public void deleteById(int appointmentId) {
        String sql = "DELETE FROM appointments WHERE Appointment_Id = ?";
        jdbcTemplate.update(sql, appointmentId);
    }
    
    @SuppressWarnings("deprecation")
	public List<AppointmentModel> findByDateAndId(int doctorId,Date appointmentdate) {
		return null;
//        String sql = "SELECT a.*, d.Doctor_Name,d.doctor_business_address,d.doctor_image_name,p.Patient_Name \r\n"
//        		+ "FROM appointments a LEFT JOIN doctors d ON a.Doctor_Id = d.Doctor_Id LEFT JOIN patient p ON a.Patient_Id = p.Patient_Id\r\n"
//        		+ "Where a.Doctor_Id = ? and appointment_date = ?";
//
//        return jdbcTemplate.query(sql, new Object[]{doctorId,appointmentdate}, (rs, rowNum) ->
//            new AppointmentModel(
//                rs.getInt("Appointment_Id"),
//                rs.getDate("Appointment_Date").toLocalDate(),
//                rs.getTimestamp("Appointment_Time").toLocalDateTime(),
//                rs.getInt("Appointment_Fee"),
//                rs.getString("Appointment_Notes"),
//                new DoctorModel(
//                    rs.getInt("Doctor_Id"),
//                    rs.getString("Doctor_Name"),
//                    rs.getString("Doctor_Business_Address"),
//                    rs.getString("Doctor_Image_Name")
//                ),
//                new PatientModel(
//                    rs.getInt("Patient_Id"),
//                    rs.getString("Patient_Name")
//                )
//            )
//        );
    }

//    @SuppressWarnings("deprecation")
//	public AppointmentModel findById(int id) {
//        return jdbcTemplate.queryForObject("SELECT * FROM appointments WHERE Appointment_Id = ?",
//                new Object[]{id},
//                (rs, rowNum) ->
//                        new AppointmentModel(
//                                rs.getInt("Appointment_Id"),
//                                rs.getDate("Appointment_Date").toLocalDate(),
//                                rs.getTimestamp("Appointment_Time").toLocalDateTime(),
//                                rs.getInt("Appointment_Fee"),
//                                rs.getString("Appointment_Notes"),
//                                null, // DoctorModel, assuming you're loading it lazily
//                                null  // PatientModel, assuming you're loading it lazily
//                        ));
//    }
    
    public void save(AppointmentModel appointment, int doctorId, int patientId) {
        String sql = "INSERT INTO appointments (Appointment_Date, Appointment_Time, Appointment_Fee, Appointment_Notes, Doctor_Id, Patient_Id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                appointment.getAppointment_Date(),
                appointment.getAppointment_Time(),
                appointment.getAppointment_Fee(),
                appointment.getAppointment_Notes(),
                doctorId,
                patientId);
    }
}
