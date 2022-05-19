package fitness.health.model;

import java.util.List;

import fitness.health.model.enums.DietType;
import fitness.health.model.enums.Gender;
import fitness.health.model.enums.RiskIngredients;
import fitness.health.model.enums.UserGoal;

public class User {
	private double bodyWeight, height;
	private int ageInYears, numberOfTrainingPerWeek;
	private Gender gender;
	private List<Exercise> favoriteExercises;
	private DietType dietType;
	private List<RiskIngredients> riskIngredients;
	private UserGoal userGoal;
	private List<Injury> injuries;
//	--- Fields which drools will calculate
	private int genderCoefficient;
	
	public User() {
		super();
	}

	public User(double bodyWeight, double height, int ageInYears, int numberOfTrainingPerWeek, Gender gender,
			List<Exercise> favoriteExercises, DietType dietType, List<RiskIngredients> riskIngredients,
			UserGoal userGoal, List<Injury> injuries, int genderCoefficient) {
		super();
		this.bodyWeight = bodyWeight;
		this.height = height;
		this.ageInYears = ageInYears;
		this.numberOfTrainingPerWeek = numberOfTrainingPerWeek;
		this.gender = gender;
		this.favoriteExercises = favoriteExercises;
		this.dietType = dietType;
		this.riskIngredients = riskIngredients;
		this.userGoal = userGoal;
		this.injuries = injuries;
		this.genderCoefficient = genderCoefficient;
	}
	
	public double getBodyWeight() {
		return bodyWeight;
	}
	public void setBodyWeight(double bodyWeight) {
		this.bodyWeight = bodyWeight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getAgeInYears() {
		return ageInYears;
	}
	public void setAgeInYears(int ageInYears) {
		this.ageInYears = ageInYears;
	}
	public int getNumberOfTrainingPerWeek() {
		return numberOfTrainingPerWeek;
	}
	public void setNumberOfTrainingPerWeek(int numberOfTrainingPerWeek) {
		this.numberOfTrainingPerWeek = numberOfTrainingPerWeek;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public List<Exercise> getFavoriteExercises() {
		return favoriteExercises;
	}
	public void setFavoriteExercises(List<Exercise> favoriteExercises) {
		this.favoriteExercises = favoriteExercises;
	}
	public DietType getDietType() {
		return dietType;
	}
	public void setDietType(DietType dietType) {
		this.dietType = dietType;
	}
	public List<RiskIngredients> getRiskIngredients() {
		return riskIngredients;
	}
	public void setRiskIngredients(List<RiskIngredients> riskIngredients) {
		this.riskIngredients = riskIngredients;
	}
	public UserGoal getUserGoal() {
		return userGoal;
	}
	public void setUserGoal(UserGoal userGoal) {
		this.userGoal = userGoal;
	}
	public List<Injury> getInjuries() {
		return injuries;
	}
	public void setInjuries(List<Injury> injuries) {
		this.injuries = injuries;
	}
	public int getGenderCoefficient() {
		return genderCoefficient;
	}
	public void setGenderCoefficient(int genderCoefficient) {
		this.genderCoefficient = genderCoefficient;
	}
}
