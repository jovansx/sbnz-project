import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FitnessHealthService {

  planResponse: Subject<any> = new Subject<any>();

  constructor(private http: HttpClient) { }

  public getPlan(data : any) : void {
    this.http.post<any>("http://localhost:8080/user", data).subscribe(
      (res) => {
        this.planResponse.next(res);
      },
      (err) => {console.log(err)}
    )
  }
}
