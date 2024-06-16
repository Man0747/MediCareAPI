package com.medicare.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DaysOff")
public class DaysOffModel {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "do_id")
	    private int id;

	    @ManyToOne
	    @JoinColumn(name = "doctor_id")
	    private DoctorModel doctor;

	    @Column(name = "do_DateFrom")
	    private Date dateFrom;

	    @Column(name = "do_DateTo")
	    private Date dateTo;

	    @Column(name = "do_Name")
	    private String name;

	    @Column(name = "do_RepeatEveryYear")
	    private boolean repeatEveryYear;

	    // Constructors, getters, and setters

	    public DaysOffModel() {
	    }

	    public DaysOffModel(DoctorModel doctorId, Date dateFrom, Date dateTo, String name, boolean repeatEveryYear) {
	        this.doctor = doctorId;
	        this.dateFrom = dateFrom;
	        this.dateTo = dateTo;
	        this.name = name;
	        this.repeatEveryYear = repeatEveryYear;
	    }
	
	

	   

		public DaysOffModel(int id, Date dateFrom, Date dateTo, String name, boolean repeatEveryYear) {
			super();
			this.id = id;
			this.dateFrom = dateFrom;
			this.dateTo = dateTo;
			this.name = name;
			this.repeatEveryYear = repeatEveryYear;
		}

		public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    

	    public DoctorModel getDoctor() {
			return doctor;
		}

		public void setDoctor(DoctorModel doctor) {
			this.doctor = doctor;
		}

		public Date getDateFrom() {
	        return dateFrom;
	    }

	    public void setDateFrom(Date dateFrom) {
	        this.dateFrom = dateFrom;
	    }

	    public Date getDateTo() {
	        return dateTo;
	    }

	    public void setDateTo(Date dateTo) {
	        this.dateTo = dateTo;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public boolean getRepeatEveryYear() {
	        return repeatEveryYear;
	    }

	    public void setRepeatEveryYear(boolean repeatEveryYear) {
	        this.repeatEveryYear = repeatEveryYear;
	    }
	}


