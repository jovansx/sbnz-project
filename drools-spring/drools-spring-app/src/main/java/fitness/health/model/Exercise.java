package fitness.health.model;

import java.util.List;

import fitness.health.model.enums.BodyPart;
import fitness.health.model.enums.ExerciseIntensity;
import fitness.health.model.enums.ExerciseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {
	private String name;
	private ExerciseIntensity intesity;
	private ExerciseType type;
	private List<BodyPart> activeBodyParts;
}
