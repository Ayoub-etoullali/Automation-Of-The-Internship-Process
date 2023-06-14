import { Injectable } from '@angular/core';
import {Projet} from "../../model/Projet.model";
import {HttpClient} from "@angular/common/http";
import {Etudiant} from "../../model/Etudiant.model";

@Injectable({
  providedIn: 'root'
})
export class EtudiantService {
  private backendHost = "http://localhost:8085";

  constructor(private http: HttpClient) {
  }


  getEtudiant(id: number) {
    return this.http.get<Etudiant>(this.backendHost + "/etudiants/" + id)
  }

  updateEtudiant(etudiant: Etudiant) {
    return this.http.put(this.backendHost + "/etudiants/edit/"+etudiant.id,etudiant);

  }
}
