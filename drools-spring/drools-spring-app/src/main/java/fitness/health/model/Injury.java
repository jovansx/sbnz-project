package fitness.health.model;

import fitness.health.model.enums.BodyPart;
import fitness.health.model.enums.RecoveryStrategy;

public class Injury {
	private BodyPart bodyPart;
	private RecoveryStrategy recoveryStrategy;
	
	public Injury() {
		super();
	}

	public Injury(BodyPart bodyPart, RecoveryStrategy recoveryStrategy) {
		super();
		this.bodyPart = bodyPart;
		this.recoveryStrategy = recoveryStrategy;
	}
	
	public BodyPart getBodyPart() {
		return bodyPart;
	}
	public void setBodyPart(BodyPart bodyPart) {
		this.bodyPart = bodyPart;
	}
	public RecoveryStrategy getRecoveryStrategy() {
		return recoveryStrategy;
	}
	public void setRecoveryStrategy(RecoveryStrategy recoveryStrategy) {
		this.recoveryStrategy = recoveryStrategy;
	}
	
	
}
