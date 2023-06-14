import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {OffreStage, OffreStageDetails} from "../../model/OffreStage.model";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class OffresStageService {

  private backendHost = "http://localhost:8085";
  offresStage!: Array<OffreStage>;

  constructor(private http: HttpClient) {
  }

  searchOffresStageByPoste(kw: String): Observable<Array<OffreStage>> {
    return this.http.get<Array<OffreStage>>(this.backendHost + "/offres-stage/poste/search?poste=" + kw)
  }

  OffresStage(): Observable<Array<OffreStage>> {
    return this.http.get<Array<OffreStage>>(this.backendHost + "/offres-stage/all")
  }

  /**Page**/
  getAccount(accountId: string, page: number, size: number) {
    return this.http.get<OffreStageDetails>(this.backendHost + "/offres-stage/" + accountId + "/pageOperations?page=" + page + "&size=" + size);
  }
}
