package fitness.health.configurations;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fitness.health.model.Exercise;
import fitness.health.model.Injury;
import fitness.health.model.enums.BodyPart;
import fitness.health.model.enums.ExerciseIntensity;
import fitness.health.model.enums.ExerciseType;
import fitness.health.model.enums.RecoveryStrategy;
import fitness.health.repositories.ExerciseRepository;
import fitness.health.repositories.FoodstuffRepository;
import fitness.health.repositories.InjuryRepository;
import fitness.health.repositories.UserRepository;

@Configuration
public class DbConfiguration {

    @Bean
    public CommandLineRunner populateDatabase(ExerciseRepository exerciseRepository, FoodstuffRepository foodstuffRepository, 
    		InjuryRepository injuryRepository, UserRepository userRepository) {
        return (args) -> {
        	Exercise e1 = new Exercise("Trcanje", ExerciseIntensity.NORMAL, ExerciseType.CARDIO, List.of(BodyPart.LEGS, BodyPart.CORE));
        	Exercise e2 = new Exercise("Veslanje", ExerciseIntensity.NORMAL, ExerciseType.CARDIO, List.of(BodyPart.BACK, BodyPart.ARMS, BodyPart.LEGS));
        	Exercise e3 = new Exercise("Plivanje", ExerciseIntensity.NORMAL, ExerciseType.CARDIO, List.of(BodyPart.LEGS, BodyPart.CORE, BodyPart.ARMS, BodyPart.BACK));
        	Exercise e4 = new Exercise("Preskakanje vijace", ExerciseIntensity.NORMAL, ExerciseType.CARDIO, List.of(BodyPart.LEGS, BodyPart.CORE));
        	Exercise e5 = new Exercise("Benc press", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.ARMS, BodyPart.CHEST));
        	Exercise e6 = new Exercise("Mrtvo dizanje", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.BACK, BodyPart.CORE, BodyPart.LEGS));
        	Exercise e7 = new Exercise("Cucanj", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.LEGS, BodyPart.CORE, BodyPart.BACK));
        	Exercise e8 = new Exercise("Zgibovi", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.BACK, BodyPart.ARMS));
        	Exercise e9 = new Exercise("Sklekovi", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.CHEST, BodyPart.ARMS));
        	Exercise e10 = new Exercise("Militarry press", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.ARMS, BodyPart.CORE));
        	Exercise e11 = new Exercise("Veslanje u pretklonu", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.BACK, BodyPart.ARMS, BodyPart.CORE));
        	Exercise e12 = new Exercise("Triceps ekstenzija", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.ARMS));
        	Exercise e13 = new Exercise("Pregib s bucicama", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.ARMS));
        	Exercise e14 = new Exercise("Iskorak", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.LEGS, BodyPart.CORE));
        	Exercise e15 = new Exercise("Trbusnjaci", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.CORE));

        	exerciseRepository.saveAll(List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15));
        	
        	Injury i1 = new Injury(BodyPart.ARMS, RecoveryStrategy.AVOIDANCE);
        	Injury i2 = new Injury(BodyPart.ARMS, RecoveryStrategy.REHABILITATION);
        	Injury i3 = new Injury(BodyPart.BACK, RecoveryStrategy.AVOIDANCE);
        	Injury i4 = new Injury(BodyPart.BACK, RecoveryStrategy.REHABILITATION);
        	Injury i5 = new Injury(BodyPart.CHEST, RecoveryStrategy.AVOIDANCE);
        	Injury i6 = new Injury(BodyPart.CHEST, RecoveryStrategy.REHABILITATION);
        	Injury i7 = new Injury(BodyPart.CORE, RecoveryStrategy.AVOIDANCE);
        	Injury i8 = new Injury(BodyPart.CORE, RecoveryStrategy.REHABILITATION);
        	Injury i9 = new Injury(BodyPart.LEGS, RecoveryStrategy.AVOIDANCE);
        	Injury i10 = new Injury(BodyPart.LEGS, RecoveryStrategy.REHABILITATION);
        	
        	injuryRepository.saveAll(List.of(i1, i2, i3, i4, i5, i6, i7, i8, i9, i10));
        };
    }
}