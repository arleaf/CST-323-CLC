package com.gcu.main_application.users;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * UsersModel class
 */
//create userInfo objects that can be displayed and updated using getters and setters
@Table("users")
public class UsersModel {
	
	/** The id users. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUsers;
	
	/** The first name. */
	@Column
	private String firstName;
	
	/** The last name. */
	@Column
	private String lastName;	
	
	/** The password. */
	@Column
	private String password;
	
	/**
	 * Instantiates a new users model.
	 */
	public UsersModel() {}
	
	/**
	 * Instantiates a new users model.
	 *
	 * @param idUser the id user
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param password the password
	 */
	public UsersModel(int idUser, String firstName, String lastName, String password) {
		this.idUsers = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
	/**
	 * Gets the id user.
	 *
	 * @return the id user
	 */
	public int getIdUser() {
		return idUsers;
	}
	
	/**
	 * Sets the id user.
	 *
	 * @param id the new id user
	 */
	public void setIdUser(int id) {
		this.idUsers = id;
	}
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Don't want to print the password in a final implementation, but it's here for now
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Id: " + idUsers +
				"First Name: " + firstName +
				"Last Name: " + lastName +
				"Password: " + password;
	}
}
