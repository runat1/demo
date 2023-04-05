package com.users.demo.controller;

import com.users.demo.model.User;
import com.users.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/")
public class UserController {
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String getUsers(Model model) {
		model.addAttribute("users", userService.getListOfUsers());
		return "/all-user";
	}
	@GetMapping("/newUser")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "newUser";
	}
	@GetMapping("user-delete/{id}")
	public String deleteUsers(@PathVariable("id") Long id){
		userService.deleteUserById(id);
		return "redirect:/";
	}
	@GetMapping("/{id}/getUser")
	public String getUserId(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getUserId(id));
		return "remove";
	}

	@PatchMapping
	public String edditUser(@ModelAttribute("user") User user,
						   @PathVariable("id") Long id) {
		userService.edditUser( id, user);
		return "redirect:/";
	}


	@PostMapping
	public String creatNewUser(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/";
	}
}