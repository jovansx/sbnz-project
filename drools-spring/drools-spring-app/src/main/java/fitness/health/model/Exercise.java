package fitness.health.model;

import java.util.List;

import fitness.health.model.enums.BodyPart;
import fitness.health.model.enums.ExerciseIntensity;
import fitness.health.model.enums.ExerciseType;

public class Exercise {
	private String name;
	private ExerciseIntensity intesity;
	private ExerciseType type;
	private List<BodyPart> activeBodyParts;
	
	public Exercise() {
		super();
	}

	public Exercise(String name, ExerciseIntensity intesity, ExerciseType type, List<BodyPart> activeBodyParts) {
		super();
		this.name = name;
		this.intesity = intesity;
		this.type = type;
		this.activeBodyParts = activeBodyParts;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ExerciseIntensity getIntesity() {
		return intesity;
	}
	public void setIntesity(ExerciseIntensity intesity) {
		this.intesity = intesity;
	}
	public ExerciseType getType() {
		return type;
	}
	public void setType(ExerciseType type) {
		this.type = type;
	}
	public List<BodyPart> getActiveBodyParts() {
		return activeBodyParts;
	}
	public void setActiveBodyParts(List<BodyPart> activeBodyParts) {
		this.activeBodyParts = activeBodyParts;
	}
}
