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
public class FoodstuffService {
	
	private final FoodstuffRepository foodstuffRepository;

	@Autowired
	public FoodstuffService(FoodstuffRepository foodstuffRepository) {
		this.foodstuffRepository = foodstuffRepository;
	}

	public List<Foodstuff> getAllFood() {
		List<Foodstuff> allFood = foodstuffRepository.findAllAndFetchAllDietTypes();
		List<Foodstuff> allFoodWithIngredients = foodstuffRepository.findAllAndFetchAllRiskIngredients();
		for (Foodstuff food : allFood) {
			for (Foodstuff foodstuff : allFoodWithIngredients) {
				if(food.getName().equals(foodstuff.getName())) {
					food.setRiskIngredients(foodstuff.getRiskIngredients());
				}
			}
		}
		return allFood;
	}
}
