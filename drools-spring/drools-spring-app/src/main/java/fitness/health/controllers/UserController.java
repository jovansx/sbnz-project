package fitness.health.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fitness.health.dtos.RequestDTO;
import fitness.health.dtos.UserDTO;
import fitness.health.model.User;
import fitness.health.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

//	TODO Vidi za povrede sta cete
//	TODO Dodaj jos entiteta u bazu
	
	@PostMapping
	public UserDTO getPlan(@RequestBody RequestDTO requestDTO) {
		User u = new User(requestDTO);
		userService.setUserLists(u, requestDTO);
		userService.calculatePlan(u);
		return new UserDTO(u);
	}
	
}
