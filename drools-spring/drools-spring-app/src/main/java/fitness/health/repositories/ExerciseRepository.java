package fitness.health.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fitness.health.model.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, String> {

}
