package fitness.health.services;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fitness.health.dtos.RequestDTO;
import fitness.health.model.User;
import fitness.health.model.enums.RiskIngredients;

@Service
public class UserService {

	private final KieContainer kieContainer;
	
	private final ExerciseService exerciseService;
	private final FoodstuffService foodService;
	private final InjuryService injuryService;

	@Autowired
	public UserService(KieContainer kieContainer, ExerciseService exerciseService, FoodstuffService foodService, InjuryService injuryService) {
		this.kieContainer = kieContainer;
		this.exerciseService = exerciseService;
		this.foodService = foodService;
		this.injuryService = injuryService;
	}
	
	public void setUserLists(User u, RequestDTO dto) {
		exerciseService.setUserFavoriteExercises(u, dto.getFavoriteExerciseNames());
		injuryService.setUserInjuries(u, dto.getInjuries());
		setUserRiskIngridient(u, dto.getRiskIngridientsNames());
	}

	public void calculatePlan(User u) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(u);
		exerciseService.getAllExercises().stream().forEach(e -> kieSession.insert(e));
		foodService.getAllFood().stream().forEach(e -> kieSession.insert(e));
		kieSession.fireAllRules();
		kieSession.dispose();
	}
	
	private void setUserRiskIngridient(User u, List<String> riskIngridientsNames) {
		List<RiskIngredients> riskIngredients = new ArrayList<RiskIngredients>();
		try {
			for (String ingridientName : riskIngridientsNames) {
					RiskIngredients i = RiskIngredients.valueOf(ingridientName);
					riskIngredients.add(i);
			}
		} catch (Exception e) {
			throw new RuntimeException("Risk ingridient does not exist!");
		}
		u.setRiskIngredients(riskIngredients);
	}

}
