package fitness.health.events;

public class AddedFavoriteCardioExercises {

	private Long userId;
	
	public AddedFavoriteCardioExercises(Long userId) {
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
