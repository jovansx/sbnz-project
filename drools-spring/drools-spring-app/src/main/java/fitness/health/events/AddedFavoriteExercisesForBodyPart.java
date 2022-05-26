package fitness.health.events;

import fitness.health.model.enums.BodyPart;

public class AddedFavoriteExercisesForBodyPart {

	private BodyPart bodyPart;
	private Long userId;
	
	public AddedFavoriteExercisesForBodyPart(BodyPart bodyPart, Long userId) {
		super();
		this.bodyPart = bodyPart;
		this.userId = userId;
	}

	public BodyPart getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(BodyPart bodyPart) {
		this.bodyPart = bodyPart;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
