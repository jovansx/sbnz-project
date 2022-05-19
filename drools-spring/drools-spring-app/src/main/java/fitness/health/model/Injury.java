package fitness.health.model;

import fitness.health.model.enums.BodyPart;
import fitness.health.model.enums.RecoveryStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Injury {
	private BodyPart bodyPart;
	private RecoveryStrategy recoveryStrategy;
}
