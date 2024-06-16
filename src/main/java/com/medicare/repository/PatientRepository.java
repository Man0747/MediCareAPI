package com.medicare.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.medicare.model.DaysOffModel;
import com.medicare.model.DoctorModel;
import com.medicare.model.EmergencyContactModel;
import com.medicare.model.MedicalHistoryModel;
import com.medicare.model.PatientModel;
import com.medicare.model.WorkingTimeModel;

@Repository
public class PatientRepository {
	@Autowired
    private JdbcTemplate jdbcTemplate;
    
//    public void addPatient(PatientModel patient) {
//        String insertPatientSql = "INSERT INTO Patient (Patient_Name, Patient_DOB, Patient_Gender, Patient_Address, Patient_Phone, Patient_Email)\r\n"
//        		+ "VALUES (?, ?, ?, ?, ?, ?);";
////        jdbcTemplate.update(insertPatientSql, patient.getPatient_Name(),patient.getPatient_DOB(),patient.getPatient_Gender(), patient.getPatient_Address(), patient.getPatient_Phone(),patient.getPatient_Email());
//        
//        KeyHolder patientkeyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(connection -> {
//            PreparedStatement ps = connection.prepareStatement(insertPatientSql, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, patient.getPatient_Name());
//            ps.setDate(2, patient.getPatient_DOB());
//            ps.setString(3, patient.getPatient_Gender());
//            ps.setString(4, patient.getPatient_Address());
//            ps.setString(5, patient.getPatient_Phone());
//            ps.setString(6, patient.getPatient_Email());
//            return ps;
//        }, patientkeyHolder);
//        
//       int recievedPatientId =  patientkeyHolder.getKey().intValue();
////Save EmergencyContact
//       EmergencyContactModel  emergencyContact = patient.getEmergencyContact();
//       String insertEmergencyContactSql = "INSERT INTO Emergency_Contact (Emergency_Contact_Name, Emergency_Contact_Relationship, Emergency_Contact_Phone)\r\n"
//       		+ "VALUES ( ?, ?, ?);";
////       jdbcTemplate.update(insertEmergencyContactSql, recievedPatientId, emergencyContact.getContactName(), emergencyContact.getContactRelationship(), emergencyContact.getContactPhone());
//
//       KeyHolder emergencyContactkeyHolder = new GeneratedKeyHolder();
//       jdbcTemplate.update(connection -> {
//           PreparedStatement ps = connection.prepareStatement(insertEmergencyContactSql, Statement.RETURN_GENERATED_KEYS);
////           ps.setInt(1, recievedPatientId);
//           ps.setString(1, emergencyContact.getContactName());
//           ps.setString(2, emergencyContact.getContactRelationship());
//           ps.setString(3, emergencyContact.getContactPhone());
//           return ps;
//       }, emergencyContactkeyHolder);
//       
//       int recievedEmergencyContactID =  emergencyContactkeyHolder.getKey().intValue();
//       //Save MedicalHistory
//       MedicalHistoryModel medicalHistory = patient.getMedicalHistory();
//        String insertMedicalHistorySql = "INSERT INTO Medical_History ( Medical_History_Conditions, Medical_History_Medications, Medical_History_Allergies)\r\n"
//        		+ "VALUES ( ?, ?, ?);";
////        jdbcTemplate.update(insertMedicalHistorySql, recievedPatientId, medicalHistory.getMedicalConditions(), medicalHistory.getMedications(), medicalHistory.getAllergies());
//        
//        KeyHolder medicalHistorykeyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(connection -> {
//            PreparedStatement ps = connection.prepareStatement(insertMedicalHistorySql, Statement.RETURN_GENERATED_KEYS);
////            ps.setInt(1, recievedPatientId);
//            ps.setString(1, medicalHistory.getMedicalConditions());
//            ps.setString(2, medicalHistory.getMedications());
//            ps.setString(3,medicalHistory.getAllergies());
//            return ps;
//        }, medicalHistorykeyHolder);
//        
//        int recievedMmedicalHistoryID =  emergencyContactkeyHolder.getKey().intValue();
//        String UpdatePatient = "UPDATE Patient\r\n"
//        		+ "	SET medical_history_id = ?,\r\n"
//        		+ "		emergency_contact_id = ?\r\n"
//        		+ "	WHERE patient_id = ?";
//        jdbcTemplate.update(UpdatePatient,recievedMmedicalHistoryID,recievedEmergencyContactID,recievedPatientId);
//        
//    }

	public void addPatient(PatientModel patient) {
	    jdbcTemplate.update("{call AddPatientWithDetails(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}",
	            patient.getPatient_Name(),
	            patient.getPatient_DOB(),
	            patient.getPatient_Gender(),
	            patient.getPatient_Address(),
	            patient.getPatient_Phone(),
	            patient.getPatient_Email(),
	            patient.getEmergencyContact().getContactName(),
	            patient.getEmergencyContact().getContactRelationship(),
	            patient.getEmergencyContact().getContactPhone(),
	            patient.getMedicalHistory().getMedicalConditions(),
	            patient.getMedicalHistory().getMedications(),
	            patient.getMedicalHistory().getAllergies()
	    );
	}
}
