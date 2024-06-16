package com.medicare.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.medicare.model.SpecialityModel;

@Repository
public class SpecialityRepository {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	 public List<SpecialityModel> findAll() {
	        return jdbcTemplate.query("SELECT * FROM speciality", (rs, rowNum) ->
	                new SpecialityModel(
	                		rs.getInt("Speciality_Id"),
	                		rs.getString("Speciality_Name"),
	                		rs.getString("Speciality_Description")
	                		
	                ));
	    }

	    @SuppressWarnings("deprecation")
		public SpecialityModel findById(int id) {
	        return jdbcTemplate.queryForObject("SELECT * FROM speciality WHERE Speciality_Id = ?", new Object[]{id}, (rs, rowNum) ->
	        new SpecialityModel(
            		rs.getInt("Speciality_Id"),
            		rs.getString("Speciality_Name"),
            		rs.getString("Speciality_Description")
            		
            ));
	    }
}
