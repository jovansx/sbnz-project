package fitness.health.model;

import java.util.List;

import fitness.health.model.enums.DietType;
import fitness.health.model.enums.RiskIngredients;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Foodstuff {
	private String name;
	private List<DietType> belongsToDiets;
	private List<RiskIngredients> riskIngredients;
}
