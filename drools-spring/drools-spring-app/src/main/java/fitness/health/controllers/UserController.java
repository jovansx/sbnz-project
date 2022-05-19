package fitness.health.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fitness.health.model.User;
import fitness.health.model.enums.Gender;
import fitness.health.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/gender/male")
	public User getMaleUser() {
		User user = new User();
		user.setGender(Gender.MALE);
		return userService.getUpdatedUser(user);
	}
	
	@GetMapping("/gender/female")
	public User getFemaleUser() {
		User user = new User();
		user.setGender(Gender.FEMALE);
		return userService.getUpdatedUser(user);
	}
	
}
