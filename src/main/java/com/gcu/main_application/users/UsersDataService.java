package com.gcu.main_application.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.main_application.data.DataAccessInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//Implements CRUD operations for Users table
/**
 * The Class UsersDataService.
 *
 * @param <T> the generic type
 */
//This class may not be needed because the data access has been 
//using the Spring Data JPA, but I will keep it for now.
@Service
public class UsersDataService<T> implements DataAccessInterface<T> {
	
	/** The user repository interface. */
	@Autowired
	private UsersRepositoryInterface userRepositoryInterface;

	private static final Logger logger = LoggerFactory.getLogger(UsersDataService.class);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	//Return all users in the table
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		logger.info("Entering UsersDataService.findAll()");
		List<UsersModel> users = new ArrayList<UsersModel>();
		
		try {
			//get all orders
			Iterable<UsersModel> usersIterable = userRepositoryInterface.findAll();
			
			//convert to list and return
			users = new ArrayList<UsersModel>();
			usersIterable.forEach(users::add);
			logger.info("Users list returned");
		} 
		catch(Exception e){
			logger.warn("Unable to list users");
			e.printStackTrace();
		}
		logger.info("Exiting UsersDataService.findAll()");
		return (List<T>) users;
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the t
	 */
	//find single UserModel by id
	@SuppressWarnings("unchecked")
	@Override
	public T findById(int id) {
		logger.info("Entering UsersDataService.findById()");
		Optional<UsersModel> returnUser = Optional.of(new UsersModel());
		
		try {
			//get user that matches id
			returnUser = userRepositoryInterface.findById(id);
			logger.info("Successfully found userid: "+id);
		}
		catch (Exception e){

			logger.warn("Unable to find userId: "+id);
			e.printStackTrace();
		}

		logger.info("Entering UsersDataService.findById()");
		return (T) returnUser;
	}

	/**
	 * Creates the.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	//create a user
	public boolean create(UsersModel user) {
		logger.info("Entering UsersDataService.create()");
		try {
			this.userRepositoryInterface.save(user);
			logger.info("Successfully created User.");
		}
		catch (Exception e){
			logger.warn("Unable to create User!)");
			e.printStackTrace();
			return false;
		}
		logger.info("Exiting UsersDataService.create()");
		return true;
	}
	
	/**
	 * Update.
	 *
	 * @param t the t
	 * @return true, if successful
	 */
	//update a single user
	@Override
	public boolean update(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Delete.
	 *
	 * @param t the t
	 * @return true, if successful
	 */
	@Override
	public boolean delete(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Creates the.
	 *
	 * @param t the t
	 * @return true, if successful
	 */
	@Override
	public boolean create(T t) {
		return false;
	}

}
