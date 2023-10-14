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
	 * @param idUser the id_user in DB
	 * @param firstName the first_name in DB
	 * @param lastName the last_name in DB
	 * @param password the password in DB
	 */
	public UsersModel(int idUser, String firstName, String lastName, String password) {
		this.idUsers = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
	/**
	 * Gets the idUser.
	 *
	 * @return the id user
	 */
	public int getIdUser() {
		return idUsers;
	}
	
	/**
	 * Sets the idUser.
	 *
	 * @param id the new id user
	 */
	public void setIdUser(int id) {
		this.idUsers = id;
	}
	
	/**
	 * Gets the user's first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the user's first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the user's last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the user's last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets the user's password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the user's password.
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
	 * @return the string output of users data
	 */
	@Override
	public String toString() {
		return "Id: " + idUsers +
				"First Name: " + firstName +
				"Last Name: " + lastName +
				"Password: " + password;
	}
}
