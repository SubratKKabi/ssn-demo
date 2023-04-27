import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ssn } from '../models/ssn.model';


const baseUrlSSN = 'http://localhost:8080/api/ssn';
@Injectable({
  providedIn: 'root'
})
export class SsnService {

  constructor(private http: HttpClient) { }

 

  getAllSsns(): Observable<Ssn[]> {
    return this.http.get<Ssn[]>(baseUrlSSN);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrlSSN);
  }

  saveSSN(data: any): Observable<any> {
    return this.http.post(baseUrlSSN, data);
  }
}