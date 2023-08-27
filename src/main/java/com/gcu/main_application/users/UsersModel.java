package com.gcu.main_application.users;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

//create userInfo objects that can be displayed and updated using getters and setters
@Table("users")
public class UsersModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUsers;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;	
	
	@Column
	private String password;
	
	public UsersModel() {}
	public UsersModel(int idUser, String firstName, String lastName, String password) {
		this.idUsers = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	public int getIdUser() {
		return idUsers;
	}
	public void setIdUser(int id) {
		this.idUsers = id;
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
	
	//Don't want to print the password in a final implementation
	//but adding it here for testing
	@Override
	public String toString() {
		return "Id: " + idUsers +
				"First Name: " + firstName +
				"Last Name: " + lastName +
				"Password: " + password;
	}
}
