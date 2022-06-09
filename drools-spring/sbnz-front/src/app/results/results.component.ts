import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FitnessHealthService } from '../services/fitness-health.service';

@Component({
  selector: 'app-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.scss']
})
export class ResultsComponent implements OnInit {

  plan: any | undefined;

  constructor(private fhService: FitnessHealthService, private router: Router) { }

  ngOnInit(): void {
    this.plan = this.fhService.planResponse;
  }

  ngAfterViewInit() {
    if (!this.plan)
      this.backToHome();
  }

  convertExerciseType(type: string | undefined): string {
    if (type == "CARDIO") return "Cardio";
    if (type == "STRENGTH") return "Strength";
    return "";
  }

  convertExerciseIntesity(intesity: string | undefined): string {
    if (intesity == "NORMAL") return "Normal";
    if (intesity == "REDUCED_DUE_TO_REHABILITATION") return "Reduced due to rehabilitation";
    return "";
  }

  backToHome() {
    this.router.navigate(["/home"]);
  }
}
