package fitness.health.utills;

import java.util.List;
import java.util.stream.Collectors;

import fitness.health.model.Exercise;
import fitness.health.model.User;

public class UserHelper {
	
	public static User addExercises(User user, List<Exercise> filtered, List<Exercise> allExercises) {
		user.getExercises().addAll(filtered);
		int howManyToAdd = user.getNumberOfTrainingPerWeek() - filtered.size();
		List<Exercise> exercisesCandidates = allExercises.stream().filter(e -> !filtered.contains(e)).collect(Collectors.toList());
		user.getExercises().addAll(exercisesCandidates.subList(0, howManyToAdd));
		return user;
	}
}
