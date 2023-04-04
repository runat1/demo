package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class HelloController {
	private final UserService userService;
	public HelloController(UserService userService) {
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
    @GetMapping("/{id}/remove")
    public String removeUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserId(id));
        return "remove";
    }

    @PatchMapping("/{id}")
    public String saveUser(@ModelAttribute("user") User user,
                             @PathVariable("id") long id) {
        userService.removeUser( id, user);
        return "redirect:/";
    }
	@DeleteMapping("/{id}/delete")
	public String deleteUser(@PathVariable("id") long id) {
		userService.deleteUserById(id);
		return "redirect:/";
	}
	@PostMapping
	public String creatNewUser(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/";
	}
}