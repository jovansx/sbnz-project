package fitness.health.dtos;

import java.util.ArrayList;
import java.util.List;

import fitness.health.model.Exercise;

public class AllExercisesDTO {

	List<Exercise> exercises;

	public AllExercisesDTO(List<Exercise> exercises) {
		super();
		this.exercises = exercises;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
	
		
}
