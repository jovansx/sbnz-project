package fitness.health.dtos;

import java.util.List;

import fitness.health.model.enums.DietType;
import fitness.health.model.enums.Gender;
import fitness.health.model.enums.UserGoal;

public class RequestDTO {
	
	private double weight, height;
	private Gender gender;
	private UserGoal goal;
	private int age, numberOfTrainingPerWeek;
	private DietType dietType;
	private List<String> favoriteExerciseNames;
	private List<String> riskIngridientsNames;
	private List<InjuryDTO> injuries;
	
	public RequestDTO() {
		super();
	}

	public RequestDTO(double weight, double height, Gender gender, UserGoal goal, int age, int numberOfTrainingPerWeek,
			DietType dietType, List<String> favoriteExerciseNames, List<String> riskIngridientsNames,
			List<InjuryDTO> injuries) {
		super();
		this.weight = weight;
		this.height = height;
		this.gender = gender;
		this.goal = goal;
		this.age = age;
		this.numberOfTrainingPerWeek = numberOfTrainingPerWeek;
		this.dietType = dietType;
		this.favoriteExerciseNames = favoriteExerciseNames;
		this.riskIngridientsNames = riskIngridientsNames;
		this.injuries = injuries;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public UserGoal getGoal() {
		return goal;
	}

	public void setGoal(UserGoal goal) {
		this.goal = goal;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumberOfTrainingPerWeek() {
		return numberOfTrainingPerWeek;
	}

	public void setNumberOfTrainingPerWeek(int numberOfTrainingPerWeek) {
		this.numberOfTrainingPerWeek = numberOfTrainingPerWeek;
	}

	public DietType getDietType() {
		return dietType;
	}

	public void setDietType(DietType dietType) {
		this.dietType = dietType;
	}

	public List<String> getFavoriteExerciseNames() {
		return favoriteExerciseNames;
	}

	public void setFavoriteExerciseNames(List<String> favoriteExerciseNames) {
		this.favoriteExerciseNames = favoriteExerciseNames;
	}

	public List<String> getRiskIngridientsNames() {
		return riskIngridientsNames;
	}

	public void setRiskIngridientsNames(List<String> riskIngridientsNames) {
		this.riskIngridientsNames = riskIngridientsNames;
	}

	public List<InjuryDTO> getInjuries() {
		return injuries;
	}

	public void setInjuries(List<InjuryDTO> injuries) {
		this.injuries = injuries;
	}
	
}
