package com.gcu.main_application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.main_application.users.UsersModel;
import com.gcu.main_application.users.UsersRepositoryInterface;

//This is the main controller to map to the different pages.
//Currently these pages don't have much function, but were added to provide a template.
//Using Thymeleaf to return the html documents that are located in the src/main/resources/templates folder
//Each Getmapping method generates a UserInfoModel and then displays it using Javascript in the html pages
/**
 * The Class AppController.
 */
//as an object to be displayed 
@Controller
@RequestMapping("")//not needed, but may be used later if additional mapping is needed
public class AppController 
{
	
	/** The users repository interface. */
	@Autowired UsersRepositoryInterface usersRepositoryInterface;
	
	/**
	 * Page 3.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/page3")
	public String page3(Model model) 
	{
		model.addAttribute("userInfo", new UsersModel());
		return "page3";
	}
	
	/**
	 * Page 3 submit.
	 *
	 * @param userInfo the user info
	 * @param model the model
	 * @return the string
	 */
	@PostMapping("/page3")
	public String page3Submit(@ModelAttribute UsersModel userInfo, Model model)
	{
		model.addAttribute("userInfo", userInfo);
		return "page3";
	}
}
