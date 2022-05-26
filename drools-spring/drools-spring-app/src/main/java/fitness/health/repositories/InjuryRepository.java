package fitness.health.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fitness.health.model.Injury;

public interface InjuryRepository extends JpaRepository<Injury, Long>{

}
