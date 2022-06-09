package fitness.health.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fitness.health.model.Exercise;
import fitness.health.model.Foodstuff;

public interface FoodstuffRepository extends JpaRepository<Foodstuff, String>{

	@Query("select distinct d from Foodstuff d join fetch d.belongsToDiets i")
	List<Foodstuff> findAllAndFetchAllDietTypes();

	@Query("select distinct d from Foodstuff d left join fetch d.riskIngredients i")
	List<Foodstuff> findAllAndFetchAllRiskIngredients();
}
