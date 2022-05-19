package fitness.health.model;

import java.util.List;

import fitness.health.model.enums.DietType;
import fitness.health.model.enums.RiskIngredients;

public class Foodstuff {
	private String name;
	private List<DietType> belongsToDiets;
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
