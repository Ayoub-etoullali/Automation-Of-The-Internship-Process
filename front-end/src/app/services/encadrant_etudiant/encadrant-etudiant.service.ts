import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import {EncadrantEtudiant} from "../../model/encadrant-etudiant";

@Injectable({
  providedIn: 'root'
})
export class EncadrantEtudiantService {
  private apiUrl = "http://localhost:8085";

  constructor(private http: HttpClient) { }

  getEtudiant(stageId: number): Observable<EncadrantEtudiant> {
    return this.http.get<EncadrantEtudiant>(`${this.apiUrl}/api/stages/${stageId}/etudiant`);
  }
}
