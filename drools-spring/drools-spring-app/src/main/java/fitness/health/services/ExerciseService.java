package fitness.health.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fitness.health.model.Exercise;
import fitness.health.model.Foodstuff;
import fitness.health.model.User;
import fitness.health.repositories.ExerciseRepository;
import fitness.health.repositories.FoodstuffRepository;

@Service
public class ExerciseService {
	
	private final ExerciseRepository exerciseRepository;

	@Autowired
	public ExerciseService(ExerciseRepository exerciseRepository) {
		this.exerciseRepository = exerciseRepository;
	}
	
	public List<Exercise> getAllExercises() {
		return exerciseRepository.findAllAndFetchAll();
	}
	
	public void setUserFavoriteExercises(User u, String favoriteExerciseNames) {
		List<Exercise> exercises = new ArrayList();
		for (String exerciseName : favoriteExerciseNames.split(",")) {
			Optional<Exercise> optional = exerciseRepository.findByExerciseName(exerciseName);
			if(optional.isEmpty()) {
				throw new RuntimeException("Exercise with name " + exerciseName + " does not exist!");
			}
			exercises.add(optional.get());
		}
		u.setFavoriteExercises(exercises);
	}
}
