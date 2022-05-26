package fitness.health.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fitness.health.model.Foodstuff;

public interface FoodstuffRepository extends JpaRepository<Foodstuff, String>{

}
