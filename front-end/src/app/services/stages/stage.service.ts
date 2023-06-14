import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StageService {
  private apiUrl = "http://localhost:8085";

  constructor(private http: HttpClient) { }

  getStages(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl + "/api/encadrant/1/stages");
  }

  getEtudiantByStage(stageId: number): Observable<any> {
    return this.http.get<any>(this.apiUrl + "/etudiants/" + stageId);
  }
}
