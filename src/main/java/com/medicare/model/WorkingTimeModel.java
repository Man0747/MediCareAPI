package com.medicare.model;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "WorkingTime")
public class WorkingTimeModel {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "wt_id")
	    private int id;

	    @OneToOne
	    @JoinColumn(name = "doctor_id")
	    private DoctorModel doctor;

	    @Column(name = "MondayFrom")
	    private Time mondayFrom;

	    @Column(name = "MondayTo")
	    private Time mondayTo;

	    @Column(name = "TuesdayFrom")
	    private Time tuesdayFrom;

	    @Column(name = "TuesdayTo")
	    private Time tuesdayTo;

	    @Column(name = "WednesdayFrom")
	    private Time wednesdayFrom;

	    @Column(name = "WednesdayTo")
	    private Time wednesdayTo;

	    @Column(name = "ThursdayFrom")
	    private Time thursdayFrom;

	    @Column(name = "ThursdayTo")
	    private Time thursdayTo;

	    @Column(name = "FridayFrom")
	    private Time fridayFrom;

	    @Column(name = "FridayTo")
	    private Time fridayTo;

	    @Column(name = "SaturdayFrom")
	    private Time saturdayFrom;

	    @Column(name = "SaturdayTo")
	    private Time saturdayTo;

	    @Column(name = "SundayFrom")
	    private Time sundayFrom;

	    @Column(name = "SundayTo")
	    private Time sundayTo;

	    // Constructors, getters, and setters

	    public DoctorModel getDoctor() {
			return doctor;
		}

		public void setDoctor(DoctorModel doctor) {
			this.doctor = doctor;
		}

		
	    

		public WorkingTimeModel() {
			super();
			// TODO Auto-generated constructor stub
		}

		public WorkingTimeModel(int id, Time mondayFrom, Time mondayTo, Time tuesdayFrom, Time tuesdayTo,
				Time wednesdayFrom, Time wednesdayTo, Time thursdayFrom, Time thursdayTo, Time fridayFrom,
				Time fridayTo, Time saturdayFrom, Time saturdayTo, Time sundayFrom, Time sundayTo) {
			super();
			this.id = id;
			this.mondayFrom = mondayFrom;
			this.mondayTo = mondayTo;
			this.tuesdayFrom = tuesdayFrom;
			this.tuesdayTo = tuesdayTo;
			this.wednesdayFrom = wednesdayFrom;
			this.wednesdayTo = wednesdayTo;
			this.thursdayFrom = thursdayFrom;
			this.thursdayTo = thursdayTo;
			this.fridayFrom = fridayFrom;
			this.fridayTo = fridayTo;
			this.saturdayFrom = saturdayFrom;
			this.saturdayTo = saturdayTo;
			this.sundayFrom = sundayFrom;
			this.sundayTo = sundayTo;
		}

		public WorkingTimeModel(int id, DoctorModel doctor, Time mondayFrom, Time mondayTo, Time tuesdayFrom,
				Time tuesdayTo, Time wednesdayFrom, Time wednesdayTo, Time thursdayFrom, Time thursdayTo,
				Time fridayFrom, Time fridayTo, Time saturdayFrom, Time saturdayTo, Time sundayFrom, Time sundayTo) {
			super();
			this.id = id;
			this.doctor = doctor;
			this.mondayFrom = mondayFrom;
			this.mondayTo = mondayTo;
			this.tuesdayFrom = tuesdayFrom;
			this.tuesdayTo = tuesdayTo;
			this.wednesdayFrom = wednesdayFrom;
			this.wednesdayTo = wednesdayTo;
			this.thursdayFrom = thursdayFrom;
			this.thursdayTo = thursdayTo;
			this.fridayFrom = fridayFrom;
			this.fridayTo = fridayTo;
			this.saturdayFrom = saturdayFrom;
			this.saturdayTo = saturdayTo;
			this.sundayFrom = sundayFrom;
			this.sundayTo = sundayTo;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}


		public Time getMondayFrom() {
			return mondayFrom;
		}

		public void setMondayFrom(Time mondayFrom) {
			this.mondayFrom = mondayFrom;
		}

		public Time getMondayTo() {
			return mondayTo;
		}

		public void setMondayTo(Time mondayTo) {
			this.mondayTo = mondayTo;
		}

		public Time getTuesdayFrom() {
			return tuesdayFrom;
		}

		public void setTuesdayFrom(Time tuesdayFrom) {
			this.tuesdayFrom = tuesdayFrom;
		}

		public Time getTuesdayTo() {
			return tuesdayTo;
		}

		public void setTuesdayTo(Time tuesdayTo) {
			this.tuesdayTo = tuesdayTo;
		}

		public Time getWednesdayFrom() {
			return wednesdayFrom;
		}

		public void setWednesdayFrom(Time wednesdayFrom) {
			this.wednesdayFrom = wednesdayFrom;
		}

		public Time getWednesdayTo() {
			return wednesdayTo;
		}

		public void setWednesdayTo(Time wednesdayTo) {
			this.wednesdayTo = wednesdayTo;
		}

		public Time getThursdayFrom() {
			return thursdayFrom;
		}

		public void setThursdayFrom(Time thursdayFrom) {
			this.thursdayFrom = thursdayFrom;
		}

		public Time getThursdayTo() {
			return thursdayTo;
		}

		public void setThursdayTo(Time thursdayTo) {
			this.thursdayTo = thursdayTo;
		}

		public Time getFridayFrom() {
			return fridayFrom;
		}

		public void setFridayFrom(Time fridayFrom) {
			this.fridayFrom = fridayFrom;
		}

		public Time getFridayTo() {
			return fridayTo;
		}

		public void setFridayTo(Time fridayTo) {
			this.fridayTo = fridayTo;
		}

		public Time getSaturdayFrom() {
			return saturdayFrom;
		}

		public void setSaturdayFrom(Time saturdayFrom) {
			this.saturdayFrom = saturdayFrom;
		}

		public Time getSaturdayTo() {
			return saturdayTo;
		}

		public void setSaturdayTo(Time saturdayTo) {
			this.saturdayTo = saturdayTo;
		}

		public Time getSundayFrom() {
			return sundayFrom;
		}

		public void setSundayFrom(Time sundayFrom) {
			this.sundayFrom = sundayFrom;
		}

		public Time getSundayTo() {
			return sundayTo;
		}

		public void setSundayTo(Time sundayTo) {
			this.sundayTo = sundayTo;
		}


	    
}


