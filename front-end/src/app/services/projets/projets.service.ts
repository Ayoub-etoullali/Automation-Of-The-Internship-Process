import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Projet} from "../../model/Projet.model";
import {HttpClient} from "@angular/common/http";
import {ValidationErrors} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class ProjetsService {
  private backendHost = "http://localhost:8085";

  constructor(private http: HttpClient) {
  }

  getProjets() : Observable<Array<Projet>> {
    return this.http.get<Array<Projet>>(this.backendHost + "/projets/all")
  }

  getProjet(id: number): Observable<Projet> {
    return this.http.get<Projet>(this.backendHost + "/projets/" + id)
  }

  searchProjetByIntitule(kw: String): Observable<Array<Projet>> {
    return this.http.get<Array<Projet>>(this.backendHost + "/projets/intitule/search?intitule=" + kw)
  }

  updateEtudiant(projet: Projet) {
  return this.http.put(this.backendHost + "/projets/edit/"+projet.id,projet);
}

  getErrorMsgName(field: string, error: ValidationErrors) {
    if (error['required']) {
      return field + " is required";
    } else return "";
  }

  deleteProjet(id: number) {
    return this.http.delete(this.backendHost + "/projets/delete/" + id);
  }

  saveProjet(projet: Projet) {
    return this.http.post<Projet>(this.backendHost + "/projets/new-projet", projet);
  }
}
