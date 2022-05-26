package fitness.health.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fitness.health.dtos.AllExercisesDTO;
import fitness.health.dtos.AllFoodDTO;
import fitness.health.model.Exercise;
import fitness.health.model.Foodstuff;
import fitness.health.model.User;
import fitness.health.repositories.ExerciseRepository;
import fitness.health.repositories.FoodstuffRepository;

@Service
public class UserService {

	private final KieContainer kieContainer;
	
	private final ExerciseService exerciseService;
	private final FoodstuffService foodService;

	@Autowired
	public UserService(KieContainer kieContainer, ExerciseService exerciseService, FoodstuffService foodService) {
		this.kieContainer = kieContainer;
		this.exerciseService = exerciseService;
		this.foodService = foodService;
	}

	public User getUpdatedUser(User u, String favoriteExerciseNames) {
		exerciseService.setUserFavoriteExercises(u, favoriteExerciseNames);		
				
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(u);
		kieSession.insert(new AllExercisesDTO(exerciseService.getAllExercises()));
		kieSession.insert(new AllFoodDTO(foodService.getAllFood()));
		kieSession.fireAllRules();
		kieSession.dispose();
		return u;
	}

}
