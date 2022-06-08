import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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

  constructor(public validator: ValidatorService) {
    this.validator.setForm(this.forma);
  }

  ngOnInit(): void {
  }

  toggleGluten(): void {
    this.gluten = !this.gluten;
  }

  getPlan(): void {
    console.log(this.forma);
  }
}
