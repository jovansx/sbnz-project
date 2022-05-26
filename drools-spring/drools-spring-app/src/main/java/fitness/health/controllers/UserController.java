package fitness.health.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fitness.health.model.User;
import fitness.health.model.enums.Gender;
import fitness.health.model.enums.UserGoal;
import fitness.health.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

//	TODO Ne treba imati sve one flagove u useru vec mozemo samo insertovati i na kraju samo upisati kalorije i vezbe i hranu 9/63
//	TODO Dodaj opciju da moze razne merne jedinice
//	TODO Popravi formulu za kalorije
	@GetMapping
	public User getMaleUser(@RequestParam("weight") double weight, @RequestParam("height") double height,
			@RequestParam("gender") Gender gender, @RequestParam("goal") UserGoal goal, @RequestParam("age") int age,
			@RequestParam("numberOfTrainingPerWeek") int numberOfTrainingPerWeek, @RequestParam("favoriteExerciseNames") String favoriteExerciseNames) {
		User user = new User();
		user.setBodyWeight(weight);
		user.setHeight(height);
		user.setAgeInYears(age);
		user.setNumberOfTrainingPerWeek(numberOfTrainingPerWeek);
		user.setGender(Gender.MALE);
		user.setUserGoal(goal);
		return userService.getUpdatedUser(user, favoriteExerciseNames);
	}
	
}
