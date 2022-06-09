package fitness.health.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import fitness.health.model.enums.BodyPart;
import fitness.health.model.enums.ExerciseIntensity;
import fitness.health.model.enums.ExerciseType;

@Entity
public class Exercise {
	@Id
	private String name;
	@Enumerated(EnumType.STRING)
	private ExerciseIntensity intesity;
	@Enumerated(EnumType.STRING)
	private ExerciseType type;
	@ElementCollection(targetClass = BodyPart.class)
	@Enumerated(EnumType.STRING)
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

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activeBodyParts == null) ? 0 : activeBodyParts.hashCode());
		result = prime * result + ((intesity == null) ? 0 : intesity.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercise other = (Exercise) obj;
		if (activeBodyParts == null) {
			if (other.activeBodyParts != null)
				return false;
		} else if (!activeBodyParts.equals(other.activeBodyParts))
			return false;
		if (intesity != other.intesity)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
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
