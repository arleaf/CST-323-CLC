package com.gcu.main_application.users;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface UsersRepositoryInterface Spring Data JPA implementation.
 */
@Repository
public interface UsersRepositoryInterface extends CrudRepository<UsersModel, Integer>{

	/**
	 * Custom query to find by first name and last name and password.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param password the password
	 * @return the list
	 */
	List<UsersModel> findByFirstNameAndLastNameAndPassword(String firstName, String lastName, String password);
}
