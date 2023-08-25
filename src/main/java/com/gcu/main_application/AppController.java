package com.gcu.main_application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//This is the main controller to map to the different pages.
//Using Thymeleaf to return the html documents that are located in the src/main/resources/templates folder
//Each Getmapping method generates a UserInfoModel and then displays it using Javascript in the html pages
//as an object to be displayed 
@Controller
@RequestMapping("")//not needed, but may be used later if additional mapping is needed
public class AppController 
{
	@GetMapping("/page1")
	public String page1(Model model) 
	{
		model.addAttribute("userInfo", new UserInfoModel());
		return "page1";
	}
	
	@PostMapping("/page1")
	public String page1Submit(@ModelAttribute UserInfoModel userInfo, Model model)
	{
		model.addAttribute("userInfo", userInfo);
		return "page1";
	}
	
	@GetMapping("/page2")
	public String page2(Model model) 
	{
		model.addAttribute("userInfo", new UserInfoModel());
		return "page2";
	}
	
	@PostMapping("/page2")
	public String page2Submit(@ModelAttribute UserInfoModel userInfo, Model model)
	{
		model.addAttribute("userInfo", userInfo);
		return "page2";
	}
	
	@GetMapping("/page3")
	public String page3(Model model) 
	{
		model.addAttribute("userInfo", new UserInfoModel());
		return "page3";
	}
	
	@PostMapping("/page3")
	public String page3Submit(@ModelAttribute UserInfoModel userInfo, Model model)
	{
		model.addAttribute("userInfo", userInfo);
		return "page3";
	}
}
