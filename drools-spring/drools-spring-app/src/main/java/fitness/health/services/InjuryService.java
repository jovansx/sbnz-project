package fitness.health.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fitness.health.dtos.InjuryDTO;
import fitness.health.model.Injury;
import fitness.health.model.User;
import fitness.health.repositories.InjuryRepository;

@Service
public class InjuryService {

	private final InjuryRepository injuryRepository;

	@Autowired
	public InjuryService(InjuryRepository injuryRepository) {
		this.injuryRepository = injuryRepository;
	}
	
	public void setUserInjuries(User u, List<InjuryDTO> injuriesDTOS) {
		List<Injury> injuries = new ArrayList<Injury>();
		for (InjuryDTO injuryDTO : injuriesDTOS) {
			Optional<Injury> optional = injuryRepository.findByBodyPartAndRecoveryStrategy(injuryDTO.getBodyPart(), injuryDTO.getRecoveryStrategy());
			injuries.add(optional.get());
		}
		u.setInjuries(injuries);
		u.getStartingInjuries().addAll(u.getInjuries());
		
		Collections.sort(u.getInjuries(), new Comparator<Injury>() {
	        @Override
	        public int compare(Injury h1, Injury h2) {
	            return h1.getRecoveryStrategy().compareTo(h2.getRecoveryStrategy());
	        }
	    });
	}
	
}
