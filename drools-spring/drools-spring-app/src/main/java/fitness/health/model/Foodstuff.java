package fitness.health.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import fitness.health.model.enums.DietType;
import fitness.health.model.enums.RiskIngredients;

@Entity
public class Foodstuff {
	@Id
	private String name;
	@ElementCollection(targetClass = DietType.class)
	@Enumerated(EnumType.STRING)
	private List<DietType> belongsToDiets;
	@ElementCollection(targetClass = RiskIngredients.class)
	@Enumerated(EnumType.STRING)
	private List<RiskIngredients> riskIngredients;
	
	public Foodstuff() {
		super();
	}
	
	public Foodstuff(String name, List<DietType> belongsToDiets, List<RiskIngredients> riskIngredients) {
		super();
		this.name = name;
		this.belongsToDiets = belongsToDiets;
		this.riskIngredients = riskIngredients;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DietType> getBelongsToDiets() {
		return belongsToDiets;
	}
	public void setBelongsToDiets(List<DietType> belongsToDiets) {
		this.belongsToDiets = belongsToDiets;
	}
	public List<RiskIngredients> getRiskIngredients() {
		return riskIngredients;
	}
	public void setRiskIngredients(List<RiskIngredients> riskIngredients) {
		this.riskIngredients = riskIngredients;
	}
	
	
}
