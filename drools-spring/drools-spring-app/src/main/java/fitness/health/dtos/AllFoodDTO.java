package fitness.health.dtos;

import java.util.ArrayList;
import java.util.List;

import fitness.health.model.Exercise;
import fitness.health.model.Foodstuff;

public class AllFoodDTO {

	List<Foodstuff> foodList;

	public AllFoodDTO(List<Foodstuff> foodList) {
		super();
		this.foodList = foodList;
	}

	public List<Foodstuff> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<Foodstuff> foodList) {
		this.foodList = foodList;
	}
	
		
}
