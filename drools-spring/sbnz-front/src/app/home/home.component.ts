import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FitnessHealthService } from '../services/fitness-health.service';
import { ValidatorService } from '../services/validator.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  gluten: boolean = false;

  forma: FormGroup = new FormGroup({
    weight: new FormControl('', [Validators.required,]),
    height: new FormControl('', [Validators.required,]),
    age: new FormControl('', [Validators.required,]),
    numberOfTrainingPerWeek: new FormControl('', [Validators.required,]),
    gender: new FormControl('MALE', []),
    dietType: new FormControl('GENERAL', []),
    userGoal: new FormControl('BODY_MASS_INCREASE', []),
    lactose: new FormControl(false, []),
    gluten: new FormControl(false, []),
    peanuts: new FormControl(false, []),
    trcanje: new FormControl(false, []),
    veslanje: new FormControl(false, []),
    plivanje: new FormControl(false, []),
    preskakanjeVijace: new FormControl(false, []),
    bencPress: new FormControl(false, []),
    mrtvoDizanje: new FormControl(false, []),
    cucanj: new FormControl(false, []),
    zgibovi: new FormControl(false, []),
    sklekovi: new FormControl(false, []),
    militarryPress: new FormControl(false, []),
    veslanjeUPretklonu: new FormControl(false, []),
    tricepsEkstenzija: new FormControl(false, []),
    pregibSBucicama: new FormControl(false, []),
    iskorak: new FormControl(false, []),
    trbusnjaci: new FormControl(false, []),
    voznjaBicikla: new FormControl(false, []),
    skakanje: new FormControl(false, []),
    penjanjeUzStepenice: new FormControl(false, []),
    lateralnoPodizanje: new FormControl(false, []),
    tricepsSklekovi: new FormControl(false, []),
    veslanjeSBucicama: new FormControl(false, []),
    sklopke: new FormControl(false, []),
    izdrzaj: new FormControl(false, []),
    supermenPovlacenje: new FormControl(false, []),
    obrnutoVeslanje: new FormControl(false, []),
    latVeslanje: new FormControl(false, []),
    jednorucnoVeslanje: new FormControl(false, []),
    propadanje: new FormControl(false, []),
    letenje: new FormControl(false, []),
    obrnutiBencPress: new FormControl(false, []),
    jednonoznoMrtvoDizanje: new FormControl(false, []),
    skejtbordSkakanje: new FormControl(false, []),
    prednjiCucanj: new FormControl(false, []),
    armInjury: new FormControl('NONE', []),
    backInjury: new FormControl('NONE', []),
    legInjury: new FormControl('NONE', []),
    coreInjury: new FormControl('NONE', []),
    chestInjury: new FormControl('NONE', []),
  });

  constructor(public validator: ValidatorService, private fhService: FitnessHealthService, private router: Router) {
    this.validator.setForm(this.forma);
  }

  ngOnInit(): void {
  }

  toggleGluten(): void {
    this.gluten = !this.gluten;
  }

  getPlan(): void {
    if (this.forma.invalid) return;

    let riskIngredients: string[] = this._getRiskIngredients();
    let favoriteExercises: string[] = this._getFavoriteExercises();
    let injuries: any[] = this._getInjuries();

    let dto = {
      weight: this.forma.controls["weight"].value,
      height: this.forma.controls["height"].value,
      gender: this.forma.controls["gender"].value,
      dietType: this.forma.controls["dietType"].value,
      goal: this.forma.controls["userGoal"].value,
      riskIngridientsNames: riskIngredients,
      age: this.forma.controls["age"].value,
      numberOfTrainingPerWeek: this.forma.controls["numberOfTrainingPerWeek"].value,
      favoriteExerciseNames: favoriteExercises,
      injuries
    }
    this.router.navigate(["/results"]);

    this.fhService.getPlan(dto);
  }

  private _getRiskIngredients(): string[] {
    let riskIngredients: string[] = [];

    if (this.forma.controls["gluten"].value)
      riskIngredients.push("GLUTEN");
    if (this.forma.controls["lactose"].value)
      riskIngredients.push("LACTOSE");
    if (this.forma.controls["peanuts"].value)
      riskIngredients.push("PEANUTS");

    return riskIngredients;
  }

  private _getFavoriteExercises(): string[] {
    let exercises: string[] = [];

    if (this.forma.controls["trcanje"].value)                exercises.push("Trcanje");
    if (this.forma.controls["veslanje"].value)               exercises.push("Veslanje");
    if (this.forma.controls["plivanje"].value)               exercises.push("Plivanje");
    if (this.forma.controls["preskakanjeVijace"].value)      exercises.push("Preskakanje vijace");
    if (this.forma.controls["bencPress"].value)              exercises.push("Benc press");
    if (this.forma.controls["mrtvoDizanje"].value)           exercises.push("Mrtvo dizanje");
    if (this.forma.controls["cucanj"].value)                 exercises.push("Cucanj");
    if (this.forma.controls["zgibovi"].value)                exercises.push("Zgibovi");
    if (this.forma.controls["sklekovi"].value)               exercises.push("Sklekovi");
    if (this.forma.controls["militarryPress"].value)         exercises.push("Militarry press");
    if (this.forma.controls["veslanjeUPretklonu"].value)     exercises.push("Veslanje u pretklonu");
    if (this.forma.controls["tricepsEkstenzija"].value)      exercises.push("Triceps ekstenzija");
    if (this.forma.controls["pregibSBucicama"].value)        exercises.push("Pregib s bucicama");
    if (this.forma.controls["iskorak"].value)                exercises.push("Iskorak");
    if (this.forma.controls["trbusnjaci"].value)             exercises.push("Trbusnjaci");
    if (this.forma.controls["voznjaBicikla"].value)          exercises.push("Voznja bicikla");
    if (this.forma.controls["skakanje"].value)               exercises.push("Skakanje");
    if (this.forma.controls["penjanjeUzStepenice"].value)    exercises.push("Penjanje uz stepenice");
    if (this.forma.controls["lateralnoPodizanje"].value)     exercises.push("Laternalno podizanje");
    if (this.forma.controls["tricepsSklekovi"].value)        exercises.push("Triceps sklekovi");
    if (this.forma.controls["veslanjeSBucicama"].value)      exercises.push("Veslanje s bucicama");
    if (this.forma.controls["sklopke"].value)                exercises.push("Sklopke");
    if (this.forma.controls["izdrzaj"].value)                exercises.push("Izdrzaj");
    if (this.forma.controls["supermenPovlacenje"].value)     exercises.push("Supermen povlacenje");
    if (this.forma.controls["obrnutoVeslanje"].value)        exercises.push("Obrnuto veslanje");
    if (this.forma.controls["latVeslanje"].value)            exercises.push("Lat veslanje");
    if (this.forma.controls["jednorucnoVeslanje"].value)     exercises.push("Jednorucno veslanje");
    if (this.forma.controls["propadanje"].value)             exercises.push("Propadanje");
    if (this.forma.controls["letenje"].value)                exercises.push("Letenje");
    if (this.forma.controls["obrnutiBencPress"].value)       exercises.push("Obrnuti benc press");
    if (this.forma.controls["jednonoznoMrtvoDizanje"].value) exercises.push("Jednonozno mrtvo dizanje");
    if (this.forma.controls["skejtbordSkakanje"].value)      exercises.push("Skejtbord skakanje");
    if (this.forma.controls["prednjiCucanj"].value)          exercises.push("Prednji cucanj");

    return exercises;
  }

  private _getInjuries(): any[] {
    let injuries: any[] = [];

    if (this.forma.controls["armInjury"].value != 'NONE')
      injuries.push({ bodyPart: "ARMS", recoveryStrategy: this.forma.controls["armInjury"].value});
    if (this.forma.controls["backInjury"].value != 'NONE')
      injuries.push({ bodyPart: "BACK", recoveryStrategy: this.forma.controls["backInjury"].value});
    if (this.forma.controls["legInjury"].value != 'NONE')
      injuries.push({ bodyPart: "LEGS", recoveryStrategy: this.forma.controls["legInjury"].value});
    if (this.forma.controls["coreInjury"].value != 'NONE')
      injuries.push({ bodyPart: "CORE", recoveryStrategy: this.forma.controls["coreInjury"].value});
    if (this.forma.controls["chestInjury"].value != 'NONE')
      injuries.push({ bodyPart: "CHEST", recoveryStrategy: this.forma.controls["chestInjury"].value});

    return injuries;
  }
}
