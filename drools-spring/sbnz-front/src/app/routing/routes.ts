import { Routes } from "@angular/router";
import { HomeComponent } from "../home/home.component";
import { ResultsComponent } from "../results/results.component";

export const routes: Routes = [
    {
        path: 'home',
        component: HomeComponent,
    },
    {
        path: 'results',
        component: ResultsComponent,
    },
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: '**', redirectTo: '/home' },
  ];