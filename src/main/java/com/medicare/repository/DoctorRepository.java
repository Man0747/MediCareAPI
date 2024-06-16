package com.medicare.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.medicare.model.DoctorModel;
import com.medicare.model.SpecialityModel;
import com.medicare.model.WorkingTimeModel;
import com.medicare.model.DaysOffModel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DoctorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addDoctor(DoctorModel doctor) {
        // Define the SQL for the stored procedure call for inserting a doctor
        String insertDoctorSql = "{call InsertDoctorWithDetails(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        int doctorId = jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement cs = connection.prepareCall(insertDoctorSql)) {
                // Set IN parameters
                cs.setString(1, doctor.getDoctor_Name());
                cs.setString(2, doctor.getDoctor_Email());
                cs.setString(3, doctor.getDoctor_Address());
                cs.setInt(4, doctor.getDoctor_Phone());
                cs.setString(5, doctor.getDoctor_Clinic_Name());
                cs.setInt(6, doctor.getDoctor_Experience());
                cs.setString(7, doctor.getDoctor_About());
                cs.setInt(8, doctor.getSpeciality_Id());

                // Working time
                cs.setTime(9, doctor.getWorkingTime().getMondayFrom());
                cs.setTime(10, doctor.getWorkingTime().getMondayTo());
                cs.setTime(11, doctor.getWorkingTime().getTuesdayFrom());
                cs.setTime(12, doctor.getWorkingTime().getTuesdayTo());
                cs.setTime(13, doctor.getWorkingTime().getWednesdayFrom());
                cs.setTime(14, doctor.getWorkingTime().getWednesdayTo());
                cs.setTime(15, doctor.getWorkingTime().getThursdayFrom());
                cs.setTime(16, doctor.getWorkingTime().getThursdayTo());
                cs.setTime(17, doctor.getWorkingTime().getFridayFrom());
                cs.setTime(18, doctor.getWorkingTime().getFridayTo());
                cs.setTime(19, doctor.getWorkingTime().getSaturdayFrom());
                cs.setTime(20, doctor.getWorkingTime().getSaturdayTo());
                cs.setTime(21, doctor.getWorkingTime().getSundayFrom());
                cs.setTime(22, doctor.getWorkingTime().getSundayTo());

                // Register the OUT parameter
                cs.registerOutParameter(23, Types.INTEGER);

                // Execute the stored procedure
                cs.execute();

                // Retrieve the value of the OUT parameter
                return cs.getInt(23);
            } catch (SQLException e) {
                throw new RuntimeException("Error executing stored procedure", e);
            }
        });

        // Insert days off details
        List<DaysOffModel> daysOffList = doctor.getDaysOff();
        for (DaysOffModel daysOff : daysOffList) {
            addDaysOff(doctorId, daysOff);
        }
    }

    private void addDaysOff(int doctorId, DaysOffModel daysOff) {
        // Call the stored procedure for inserting days off details
        jdbcTemplate.update("{call InsertDayOff(?, ?, ?, ?, ?)}",
                doctorId,
                daysOff.getDateFrom(),
                daysOff.getDateTo(),
                daysOff.getName(),
                daysOff.getRepeatEveryYear()
        );
    }
    public List<DoctorModel> FindAllDoctors() {
        return jdbcTemplate.query("{call FindAllDoctors()}", (rs, rowNum) ->
                new DoctorModel(
                		rs.getInt("Doctor_Id"),
                		rs.getString("Doctor_Name"),
                		rs.getString("Doctor_Email"),
                		rs.getString("Doctor_Address"),
                		rs.getInt("Doctor_Phone"),
                		rs.getString("Doctor_Clinic_Name"),
                		rs.getInt("Doctor_Experience"),
                		rs.getString("Doctor_About"),
                		rs.getString("Doctor_Image_Name"),
                		rs.getInt("Speciality_Id")                		
                ));
    }
    @SuppressWarnings("deprecation")
    public List<DoctorModel> FindDoctorBySpecialityId(int specialityId) {
        String sql = "{call FindDoctorBySpecialityId(?)}";

        return jdbcTemplate.query(sql, new Object[]{specialityId}, (rs, rowNum) ->
            new DoctorModel(
                rs.getInt("Doctor_Id"),
                rs.getString("Doctor_Name"),
                rs.getString("Doctor_Email"),
                rs.getString("Doctor_Address"),
                rs.getInt("Doctor_Phone"),
                rs.getString("Doctor_Clinic_Name"),
                rs.getInt("Doctor_Experience"),
                rs.getString("Doctor_About"),
                rs.getString("Doctor_Image_Name"),
                rs.getInt("Speciality_Id")
            )
        );
    }
    @SuppressWarnings("null")
	public DoctorModel findDoctorsDetailsById(int doctorId) {
       
        List<DaysOffModel> daysOffList = new ArrayList<>();
        WorkingTimeModel workingTime = null;

       
            // Retrieve doctor details (implement this part as needed)
  

            // Retrieve days off
            daysOffList = findDoctorDaysOff(doctorId);

            // Retrieve working time
            workingTime = findDoctorWorkingTime(doctorId);

            DoctorModel doctorModel = new DoctorModel();
			// Set the retrieved data to the doctor model
            doctorModel.setDaysOff(daysOffList);
            doctorModel.setWorkingTime(workingTime);

        

        return doctorModel;
    }

    @SuppressWarnings("deprecation")
	public List<DaysOffModel> findDoctorDaysOff(int doctorId) {
        String sql = "{call FindDoctorDaysOff(?)}";
        return jdbcTemplate.query(sql, new Object[]{doctorId}, new RowMapper<DaysOffModel>() {
            @Override
            public DaysOffModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new DaysOffModel(
                    rs.getInt("do_id"),
                    rs.getDate("do_date_From"),
                    rs.getDate("do_date_To"),
                    rs.getString("do_name"),
                    rs.getBoolean("do_repeat_Every_Year")
                );
            }
        });
    }

    @SuppressWarnings("deprecation")
	public WorkingTimeModel findDoctorWorkingTime(int doctorId) {
        String sql = "{call FindDoctorWorkingTime(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{doctorId}, new RowMapper<WorkingTimeModel>() {
            @Override
            public WorkingTimeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new WorkingTimeModel(
                    rs.getInt("wt_id"),
                    rs.getTime("monday_from"),
                    rs.getTime("monday_to"),
                    rs.getTime("tuesday_from"),
                    rs.getTime("tuesday_to"),
                    rs.getTime("wednesday_from"),
                    rs.getTime("wednesday_to"),
                    rs.getTime("thursday_from"),
                    rs.getTime("thursday_to"),
                    rs.getTime("friday_from"),
                    rs.getTime("friday_to"),
                    rs.getTime("saturday_from"),
                    rs.getTime("saturday_to"),
                    rs.getTime("sunday_from"),
                    rs.getTime("sunday_to")
                );
            }
        });
    }

}
