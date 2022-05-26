package fitness.health.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fitness.health.dtos.AllExercisesDTO;
import fitness.health.model.Exercise;
import fitness.health.model.User;
import fitness.health.repositories.ExerciseRepository;

@Service
public class UserService {

	private final KieContainer kieContainer;
	private final ExerciseRepository exerciseRepository;

	@Autowired
	public UserService(KieContainer kieContainer, ExerciseRepository exerciseRepository) {
		this.kieContainer = kieContainer;
		this.exerciseRepository = exerciseRepository;
	}

	public User getUpdatedUser(User u, String favoriteExerciseNames) {
		List<Exercise> exercises = new ArrayList();
		for (String exerciseName : favoriteExerciseNames.split(",")) {
			Optional<Exercise> optional = exerciseRepository.findByExerciseName(exerciseName);
			if(optional.isEmpty()) {
				throw new RuntimeException("Exercise with name " + exerciseName + " does not exist!");
			}
			exercises.add(optional.get());
		}
		u.setFavoriteExercises(exercises);
		List<Exercise> allExercises = exerciseRepository.findAllAndFetchAll();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(u);
		kieSession.insert(new AllExercisesDTO(allExercises));
		kieSession.fireAllRules();
		kieSession.dispose();
		return u;
	}
}
