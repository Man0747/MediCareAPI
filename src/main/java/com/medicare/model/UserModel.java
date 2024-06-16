package com.medicare.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class UserModel {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int User_Id;
		@Column(name = "User_Email")
	    private String User_Email;
		@Column(name = "User_Password")
	    private String User_Password;
		@Column(name = "User_Role")
	    private String User_Role;
		
		
		public UserModel() {
			super();
		}
		public UserModel(int user_Id, String user_Email, String user_Password, String user_Role) {
			super();
			User_Id = user_Id;
			User_Email = user_Email;
			User_Password = user_Password;
			User_Role = user_Role;
		}
		public int getUser_Id() {
			return User_Id;
		}
		public void setUser_Id(int user_Id) {
			User_Id = user_Id;
		}
		public String getUser_Email() {
			return User_Email;
		}
		public void setUser_Email(String user_Email) {
			User_Email = user_Email;
		}
		public String getUser_Password() {
			return User_Password;
		}
		public void setUser_Password(String user_Password) {
			User_Password = user_Password;
		}
		public String getUser_Role() {
			return User_Role;
		}
		public void setUser_Role(String user_Role) {
			User_Role = user_Role;
		}
		
		
}
