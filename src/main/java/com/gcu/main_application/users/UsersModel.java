package com.gcu.main_application;

//create userInfo objects that can be displayed and updated using getters and setters
public class UserInfoModel {
	private String firstName;
	private String lastName;
	private String password;
	public UserInfoModel() {}
	public UserInfoModel(String firstName, String lastName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
