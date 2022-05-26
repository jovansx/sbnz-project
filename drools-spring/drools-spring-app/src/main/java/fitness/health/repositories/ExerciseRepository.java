package fitness.health.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fitness.health.model.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, String> {

	@Query("select d from Exercise d join fetch d.activeBodyParts i where d.name = (:name)")
    Optional<Exercise> findByExerciseName(String name);
	
	@Query("select d from Exercise d join fetch d.activeBodyParts i")
    List<Exercise> findAllAndFetchAll();
}
