import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Postes} from "../../model/Postes.model";
import {OffreStageDetails} from "../../model/OffreStage.model";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ForumService {
  private backendHost = "http://localhost:8085";

  constructor(private http: HttpClient) {
  }

  searchPosteByTag(kw: String): Observable<Array<Postes>> {
    return this.http.get<Array<Postes>>(this.backendHost + "/postes/tags/search?tags=" + kw)
  }

  searchPosteByTitre(kw: String): Observable<Array<Postes>> {
    return this.http.get<Array<Postes>>(this.backendHost + "/postes/titres/search?titre=" + kw)
  }

  Postes(): Observable<Array<Postes>> {
    return this.http.get<Array<Postes>>(this.backendHost + "/postes/all")
  }

  /**Page**/
  getAccount(accountId: string, page: number, size: number) {
    return this.http.get<OffreStageDetails>(this.backendHost + "/postes/" + accountId + "/pageOperations?page=" + page + "&size=" + size);
  }

  public updatePoste(postes: Postes) {
    return this.http.put(this.backendHost + "/postes/edit/"+postes.id,postes);
  }
}

