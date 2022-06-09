package fitness.health.events;

public class ExercisesFormed {

	private Long userId;
	
	public ExercisesFormed(Long userId) {
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
