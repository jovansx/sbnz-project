package fitness.health.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fitness.health.model.Foodstuff;
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
