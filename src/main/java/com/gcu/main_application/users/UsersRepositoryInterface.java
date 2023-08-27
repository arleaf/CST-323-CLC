package com.gcu.main_application.users;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepositoryInterface extends CrudRepository<UsersModel, Integer>{

	List<UsersModel> findByFirstNameAndLastNameAndPassword(String firstName, String lastName, String password);
}
