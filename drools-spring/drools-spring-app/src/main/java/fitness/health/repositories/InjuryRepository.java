package fitness.health.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fitness.health.model.Injury;
import fitness.health.model.enums.BodyPart;
import fitness.health.model.enums.RecoveryStrategy;

public interface InjuryRepository extends JpaRepository<Injury, Long>{

	Optional<Injury> findByBodyPartAndRecoveryStrategy(BodyPart bodyPart, RecoveryStrategy recoveryStrategy);

}
