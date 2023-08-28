package com.gcu.main_application.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.main_application.data.DataAccessInterface;

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

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	//Return all users in the table
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		List<UsersModel> users = new ArrayList<UsersModel>();
		
		try {
			//get all orders
			Iterable<UsersModel> usersIterable = userRepositoryInterface.findAll();
			
			//convert to list and return
			users = new ArrayList<UsersModel>();
			usersIterable.forEach(users::add);
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		
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
		
		Optional<UsersModel> returnUser = Optional.of(new UsersModel());
		
		try {
			//get user that matches id
			returnUser = userRepositoryInterface.findById(id);
		}
		catch (Exception e){
			e.printStackTrace();
		}
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
		
		try {
			this.userRepositoryInterface.save(user);
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
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
