package fitness.health.events;

public class DietFiltered {

	private Long userId;
	
	public DietFiltered(Long userId) {
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
