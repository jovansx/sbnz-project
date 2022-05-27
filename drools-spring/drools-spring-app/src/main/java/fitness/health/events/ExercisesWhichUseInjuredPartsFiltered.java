package fitness.health.events;

public class ExercisesWhichUseInjuredPartsFiltered {

	private Long userId;
	
	public ExercisesWhichUseInjuredPartsFiltered(Long userId) {
		super();
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
