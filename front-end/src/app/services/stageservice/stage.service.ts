import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Stage} from "../../model/stage";




@Injectable({
  providedIn: 'root'
})
export class StageService {
  private backendHost = 'http://localhost:8085';

  constructor(private http: HttpClient) {}

  createStage(stage: Stage): Observable<any> {
    return this.http.post(`${this.backendHost}/stage`, stage);

  }


}
