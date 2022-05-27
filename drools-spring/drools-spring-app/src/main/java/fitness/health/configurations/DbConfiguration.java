package fitness.health.configurations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fitness.health.model.Exercise;
import fitness.health.model.Foodstuff;
import fitness.health.model.Injury;
import fitness.health.model.enums.BodyPart;
import fitness.health.model.enums.DietType;
import fitness.health.model.enums.ExerciseIntensity;
import fitness.health.model.enums.ExerciseType;
import fitness.health.model.enums.RecoveryStrategy;
import fitness.health.model.enums.RiskIngredients;
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
        	Exercise e2 = new Exercise("Veslanje", ExerciseIntensity.NORMAL, ExerciseType.CARDIO, List.of(BodyPart.BACK, BodyPart.ARMS));
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
        	Exercise e16 = new Exercise("Voznja bicikla", ExerciseIntensity.NORMAL, ExerciseType.CARDIO, List.of(BodyPart.LEGS));
        	Exercise e17 = new Exercise("Skakanje", ExerciseIntensity.NORMAL, ExerciseType.CARDIO, List.of(BodyPart.LEGS));
        	Exercise e18 = new Exercise("Penjanje uz stepenice", ExerciseIntensity.NORMAL, ExerciseType.CARDIO, List.of(BodyPart.LEGS));	
        	Exercise e19 = new Exercise("Laternalno podizanje", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.ARMS));
        	Exercise e20 = new Exercise("Triceps sklekovi", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.ARMS));
        	Exercise e21 = new Exercise("Veslanje s bucicama", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.BACK, BodyPart.ARMS));     	
        	Exercise e22 = new Exercise("Sklopke", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.CORE));
        	Exercise e23 = new Exercise("Izdrzaj", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.CORE));
        	Exercise e24 = new Exercise("Supermen povlacenje", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.CORE));        	
        	Exercise e25 = new Exercise("Obrnuto veslanje", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.BACK));
        	Exercise e26 = new Exercise("Lat veslanje", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.BACK));
        	Exercise e27 = new Exercise("Jednorucno veslanje", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.BACK));       	
        	Exercise e28 = new Exercise("Propadanje", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.CHEST));
        	Exercise e29 = new Exercise("Letenje", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.CHEST));
        	Exercise e30 = new Exercise("Obrnuti benc press", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.CHEST));       	
        	Exercise e31 = new Exercise("Jednonozno mrtvo dizanje", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.LEGS));
        	Exercise e32 = new Exercise("Skejtbord skakanje", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.LEGS));
        	Exercise e33 = new Exercise("Prednji cucanj", ExerciseIntensity.NORMAL, ExerciseType.STRENGTH, List.of(BodyPart.LEGS));

        	exerciseRepository.saveAll(List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, 
        			e16, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27, e28, e29, e30, e31, e32, e33));
        	
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
        	
        	Foodstuff f1 = new Foodstuff("Krompir", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f2 = new Foodstuff("Psenica", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), List.of(RiskIngredients.GLUTEN));
			Foodstuff f3 = new Foodstuff("Mleko", List.of(DietType.GENERAL, DietType.VEGETARIAN), List.of(RiskIngredients.LACTOSE));
			Foodstuff f4 = new Foodstuff("Kikiriki puter", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), List.of(RiskIngredients.PEANUTS));
			Foodstuff f5 = new Foodstuff("Jaje", List.of(DietType.GENERAL, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f6 = new Foodstuff("Pilece belo meso", List.of(DietType.GENERAL), new ArrayList<>());
			Foodstuff f7 = new Foodstuff("Paprika", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f8 = new Foodstuff("Pasulj", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f9 = new Foodstuff("Boranija", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f10 = new Foodstuff("Grasak", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f11 = new Foodstuff("Kukuruz", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f12 = new Foodstuff("Ovsene pahuljice", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), List.of(RiskIngredients.GLUTEN));
			Foodstuff f13 = new Foodstuff("Krmenadla", List.of(DietType.GENERAL), new ArrayList<>());
			Foodstuff f14 = new Foodstuff("Jagnjetina", List.of(DietType.GENERAL), new ArrayList<>());
			Foodstuff f15 = new Foodstuff("Prasetina", List.of(DietType.GENERAL), new ArrayList<>());
			Foodstuff f16 = new Foodstuff("Lesnik", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f17 = new Foodstuff("Badem", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f18 = new Foodstuff("Suncokret", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f19 = new Foodstuff("Oras", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f20 = new Foodstuff("Leblebija", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f21 = new Foodstuff("Kinoa", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f22 = new Foodstuff("Kajmak", List.of(DietType.GENERAL, DietType.VEGETARIAN), List.of(RiskIngredients.LACTOSE));
			Foodstuff f23 = new Foodstuff("Sir", List.of(DietType.GENERAL, DietType.VEGETARIAN), List.of(RiskIngredients.LACTOSE));
			Foodstuff f24 = new Foodstuff("Pirinac", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), List.of(RiskIngredients.GLUTEN));
			Foodstuff f25 = new Foodstuff("Zelena salata", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f26 = new Foodstuff("Sargarepa", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f27 = new Foodstuff("Cvekla", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f28 = new Foodstuff("Jagoda", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f29 = new Foodstuff("Malina", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f30 = new Foodstuff("Visnja", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f31 = new Foodstuff("Jabuka", List.of(DietType.GENERAL, DietType.VEGAN, DietType.VEGETARIAN), new ArrayList<>());
			Foodstuff f32 = new Foodstuff("Krem bananica", List.of(DietType.GENERAL, DietType.VEGETARIAN), List.of(RiskIngredients.LACTOSE));
			Foodstuff f33 = new Foodstuff("Kiflice", List.of(DietType.GENERAL, DietType.VEGETARIAN), List.of(RiskIngredients.LACTOSE, RiskIngredients.GLUTEN));
			Foodstuff f34 = new Foodstuff("Palacinke", List.of(DietType.GENERAL, DietType.VEGETARIAN), List.of(RiskIngredients.LACTOSE, RiskIngredients.GLUTEN));

			foodstuffRepository.saveAll(List.of(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10,
										f11, f12, f13, f14, f15, f16, f17, f18, f19, f20,
										f21, f22, f23, f24, f25, f26, f27, f28, f29, f30, f31, f32, f33, f34));
        };
    }
}