package com.gcu.main_application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.main_application.users.UsersModel;
import com.gcu.main_application.users.UsersRepositoryInterface;


//This is the main controller to map to the different pages.
//Using Thymeleaf to return the html documents that are located in the src/main/resources/templates folder
//Each Getmapping method generates a UserInfoModel and then displays it using Javascript in the html pages
//as an object to be displayed 
@Controller
@RequestMapping("")//not needed, but may be used later if additional mapping is needed
public class AppController 
{
	
	@Autowired UsersRepositoryInterface usersRepositoryInterface;
	
	@GetMapping("/signup")
	public String signup(Model model) 
	{
		model.addAttribute("userInfo", new UsersModel());
		return "signup";
	}
	
	@PostMapping("/signup")
    public String createUser(@ModelAttribute UsersModel userInfo, Model model) {

        // Save the new user to the database
        usersRepositoryInterface.save(userInfo);

        // Send user toString()
        model.addAttribute("userInfo", userInfo);

        return "signup"; // Redirect back to the signup page
    }
	
	@GetMapping("/userslist")
	public String page1(Model model) 
	{
		List<UsersModel> userList = (List<UsersModel>) usersRepositoryInterface.findAll();
		model.addAttribute("userList", userList);
		return "userslist";
	}
	
	@GetMapping("/edituser")
	public String editUser(Model model) 
	{
		model.addAttribute("userInfo", new UsersModel());
		return "edituser";
	}
	
	@GetMapping("/edituser/{id}")
	public String showEditForm(@PathVariable int id, Model model) {
	    // Retrieve the user from the database based on the ID
	    Optional<UsersModel> userOptional = usersRepositoryInterface.findById(id);

        UsersModel user = userOptional.get();
        model.addAttribute("user", user);
        return "edituser"; 
	}

	@PostMapping("/edituser/{id}")
	public String processEditForm(@PathVariable int id, @ModelAttribute UsersModel updatedUser) {
	    // Retrieve the user from the database based on the ID
	    Optional<UsersModel> userOptional = usersRepositoryInterface.findById(id);

        UsersModel user = userOptional.get();
        // Update the user's information with the values from the form
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setPassword(updatedUser.getPassword());

        // Save the updated user to the database
        usersRepositoryInterface.save(user);

        return "redirect:/userslist"; // Redirect back to the user list page
	}

	
	@PostMapping("/page2")
	public String page2Submit(@ModelAttribute UsersModel userInfo, Model model)
	{
		model.addAttribute("userInfo", userInfo);
		return "page2";
	}
	
	@GetMapping("/page3")
	public String page3(Model model) 
	{
		model.addAttribute("userInfo", new UsersModel());
		return "page3";
	}
	
	@PostMapping("/page3")
	public String page3Submit(@ModelAttribute UsersModel userInfo, Model model)
	{
		model.addAttribute("userInfo", userInfo);
		return "page3";
	}
}
