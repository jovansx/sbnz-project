package fitness.health.dtos;

import java.util.ArrayList;
import java.util.List;

import fitness.health.model.Exercise;
import fitness.health.model.Foodstuff;
import fitness.health.model.User;

public class UserDTO {

	private int numberOfCaloriesPerDay;
	List<Exercise> exercises;
	List<Foodstuff> foodList;

	public UserDTO(User updatedUser) {
		exercises = updatedUser.getExercises();
		foodList = updatedUser.getFoodstufList();
		numberOfCaloriesPerDay = (int) updatedUser.getCalories();
	}

	public int getNumberOfCaloriesPerDay() {
		return numberOfCaloriesPerDay;
	}

	public void setNumberOfCaloriesPerDay(int numberOfCaloriesPerDay) {
		this.numberOfCaloriesPerDay = numberOfCaloriesPerDay;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	public List<Foodstuff> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<Foodstuff> foodList) {
		this.foodList = foodList;
	}

	@Override
	public String toString() {
		return "UserDTO [numberOfCaloriesPerDay=" + numberOfCaloriesPerDay + ", exercises=" + exercises + ", foodList="
				+ foodList + "]";
	}
	
	
}
