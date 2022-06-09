import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FitnessHealthService {

  planResponse: any | undefined;

  constructor(private http: HttpClient) { }

  public getPlan(data : any) : Observable<any> {
    return this.http.post<any>("http://localhost:8080/user", data);
  }
}
