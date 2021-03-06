package fitness.health.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import fitness.health.dtos.RequestDTO;
import fitness.health.model.enums.BodyPart;
import fitness.health.model.enums.DietType;
import fitness.health.model.enums.ExerciseIntensity;
import fitness.health.model.enums.ExerciseType;
import fitness.health.model.enums.Gender;
import fitness.health.model.enums.ProgressStrategy;
import fitness.health.model.enums.RecoveryStrategy;
import fitness.health.model.enums.RiskIngredients;
import fitness.health.model.enums.UserGoal;
import fitness.health.model.enums.UserState;

@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double bodyWeight, height;
	private int ageInYears, numberOfTrainingPerWeek;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@ManyToMany
	private List<Exercise> favoriteExercises;
	@Enumerated(EnumType.STRING)
	private DietType dietType;
	@ElementCollection(targetClass = RiskIngredients.class)
	@Enumerated(EnumType.STRING)
	private List<RiskIngredients> riskIngredients;
	@Enumerated(EnumType.STRING)
	private UserGoal userGoal;
	@ManyToMany
	private List<Injury> injuries;

	//	--- Fields which drools will calculate
	@ManyToMany
	private List<Injury> startingInjuries = new ArrayList<Injury>();
	private int genderCoefficient;
	private double strategyCoefficient;
	@Enumerated(EnumType.STRING)
	private ProgressStrategy progressStrategy;
	@Enumerated(EnumType.STRING)
	private UserState currentState;
	@ManyToMany
	private List<Exercise> exercises = new ArrayList<Exercise>();
	@ManyToMany
	private List<Foodstuff> foodstufList = new ArrayList<Foodstuff>();
	private double calories;

	public User() {
		super();
	}
	
	public User(RequestDTO requestDTO) {
		bodyWeight = requestDTO.getWeight();
		height = requestDTO.getHeight();
		ageInYears = requestDTO.getAge();
		numberOfTrainingPerWeek = requestDTO.getNumberOfTrainingPerWeek();
		gender = requestDTO.getGender();
		dietType = requestDTO.getDietType();
		userGoal = requestDTO.getGoal();
		
	}
	
	public Set<Exercise> updateExercisesByInjuries(List<Exercise> allExercises) {
		Set<Exercise> deleteExercises = new HashSet<>();
		for (Injury inj: injuries) {
			if(inj.getRecoveryStrategy() == RecoveryStrategy.REHABILITATION) continue;
			deleteExercises.addAll(allExercises.stream().filter(e -> e.getActiveBodyParts().contains(inj.getBodyPart())).collect(Collectors.toList()));
		}
		injuries.clear();
		return deleteExercises;
	}

	public void addExercises(List<Exercise> filtered, List<Exercise> allExercises, BodyPart part, ExerciseType type, double numberToHave) {
		int added = 0;
		for (Exercise exercise : filtered) {
			for (Exercise exercise2 : allExercises) {
				if(exercise.getName().equals(exercise2.getName())) {
					getExercises().add(exercise);
					added += 1;
				}
			}
		}
		
		int howManyToAdd = (int) numberToHave - added;
		
		List<Exercise> exercisesCandidates;
		if(type == ExerciseType.CARDIO) {
			exercisesCandidates = allExercises.stream().filter(
					e -> !filtered.contains(e) && e.getType() == type)
					.collect(Collectors.toList());
		} else {
			exercisesCandidates = allExercises.stream().filter(
					e -> !filtered.contains(e) && e.getActiveBodyParts().contains(part) && e.getType() == type)
					.collect(Collectors.toList());
		}
		
		try {
			if(exercisesCandidates.size() != 0)
				getExercises().addAll(exercisesCandidates.subList(0, howManyToAdd));
			else 
				getExercises().addAll(allExercises.subList(0, howManyToAdd));
		} catch (Exception ignored) {
			getExercises().addAll(allExercises);
		}
		
	}
	
	public void updateExercises(List<Exercise> allExercises) {
		int initialSize = exercises.size();
		Set<Exercise> set = new HashSet<>(exercises);
		exercises.clear();
		exercises.addAll(set);
		int currentSize = exercises.size();
		
		Exercise firstExercise = exercises.get(0);
		if(firstExercise.getType() == ExerciseType.CARDIO && initialSize <= 2) {
//			Loss
			if(initialSize > currentSize) {
				List<Exercise> filteredList = allExercises.stream().filter(
						e -> !exercises.contains(e) && e.getType() == ExerciseType.CARDIO).collect(Collectors.toList());
				exercises.add(filteredList.get(0));
			}
		} else {
//			Maintain and gain
			List<Exercise> filteredList = allExercises.stream().filter(
					e -> !exercises.contains(e) && e.getType() == ExerciseType.STRENGTH).collect(Collectors.toList());
			try {
				exercises.addAll(filteredList.subList(0, initialSize - currentSize));
			} catch (Exception ignored) {
				exercises.addAll(filteredList);
			}
		}
		
		for (Injury i : startingInjuries) {
			if(i.getRecoveryStrategy() == RecoveryStrategy.REHABILITATION) {
				exercises.stream()
					.filter(e -> e.getActiveBodyParts().contains(i.getBodyPart()))
					.forEach(e -> e.setIntesity(ExerciseIntensity.REDUCED_DUE_TO_REHABILITATION));
			}
		}
		
	}
	
	public void updateFoodstufListWithRiskyIngridients() {
		RiskIngredients riskIngredient = riskIngredients.get(0);
		foodstufList = this.foodstufList.stream().filter(f -> !f.getRiskIngredients().contains(riskIngredient)).collect(Collectors.toList());
		riskIngredients.remove(riskIngredient);
	}
	
	public void updateFoodstufList(List<Foodstuff> allFood) {
		this.foodstufList = allFood.stream().filter(f -> f.getBelongsToDiets().contains(dietType)).collect(Collectors.toList());
	}
	
	public List<Injury> getStartingInjuries() {
		return startingInjuries;
	}

	public void setStartingInjuries(List<Injury> startingInjuries) {
		this.startingInjuries = startingInjuries;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public ProgressStrategy getProgressStrategy() {
		return progressStrategy;
	}

	public void setProgressStrategy(ProgressStrategy progressStrategy) {
		this.progressStrategy = progressStrategy;
	}

	public double getStrategyCoefficient() {
		return strategyCoefficient;
	}

	public void setStrategyCoefficient(double strategyCoefficient) {
		this.strategyCoefficient = strategyCoefficient;
	}

	public UserState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(UserState currentState) {
		this.currentState = currentState;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	public List<Foodstuff> getFoodstufList() {
		return foodstufList;
	}

	public void setFoodstufList(List<Foodstuff> foodstufList) {
		this.foodstufList = foodstufList;
	}
	
	
}
