package com.gcu.main_application.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.main_application.data.DataAccessInterface;

//Implements CRUD operations for Users table
//This class may not be needed, but I will keep it just in case
@Service
public class UsersDataService<T> implements DataAccessInterface<T> {
	
	@Autowired
	private UsersRepositoryInterface userRepositoryInterface;

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
	
	//update a single user
	@Override
	public boolean update(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(T t) {
		return false;
	}

}
