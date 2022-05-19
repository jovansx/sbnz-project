package fitness.health.model;

import java.util.List;

import fitness.health.model.enums.DietType;
import fitness.health.model.enums.Gender;
import fitness.health.model.enums.RiskIngredients;
import fitness.health.model.enums.UserGoal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

	public Gender getGender() {
		return gender;
	}
	
	public DietType getDietType() {
		return dietType;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getGenderCoefficient() {
		return genderCoefficient;
	}

	public void setGenderCoefficient(int genderCoefficient) {
		this.genderCoefficient = genderCoefficient;
	}

}
