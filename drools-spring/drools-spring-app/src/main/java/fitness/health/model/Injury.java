package fitness.health.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fitness.health.model.enums.BodyPart;
import fitness.health.model.enums.RecoveryStrategy;

@Entity
public class Injury {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private BodyPart bodyPart;
	@Enumerated(EnumType.STRING)
	private RecoveryStrategy recoveryStrategy;
	
	public Injury() {
		super();
	}

	public Injury(BodyPart bodyPart, RecoveryStrategy recoveryStrategy) {
		super();
		this.bodyPart = bodyPart;
		this.recoveryStrategy = recoveryStrategy;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
