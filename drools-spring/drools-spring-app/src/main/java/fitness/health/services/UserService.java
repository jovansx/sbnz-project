package fitness.health.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fitness.health.model.User;

@Service
public class UserService {

	private final KieContainer kieContainer;

	@Autowired
	public UserService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public User getUpdatedUser(User u) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(u);
		kieSession.fireAllRules();
		kieSession.dispose();
		return u;
	}
}
