import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';
import {Session} from "../../model/session";


@Injectable({
  providedIn: 'root'
})
export class SessionService {
  private apiUrl = 'http://localhost:8085/api/session-encadrement';

  constructor(private http: HttpClient) { }

  getSessions(): Observable<Session[]> {
    return this.http.get<Session[]>(this.apiUrl);
  }

  getSessionsByEtudiantId(etudiantId: number): Observable<Session[]> {
    const url = `${this.apiUrl}/etudiant/${etudiantId}`;
    return this.http.get<Session[]>(url).pipe(
      catchError((error: HttpErrorResponse) => {
        console.log(error);
        return throwError('An error occurred while retrieving the sessions.');
      })
    );
  }

  getSessionById(id: number): Observable<Session> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Session>(url).pipe(
      catchError((error: HttpErrorResponse) => {
        console.log(error);
        return throwError('An error occurred while retrieving the session.');
      })
    );
  }

  createSession(session: Session): Observable<Session> {
    return this.http.post<Session>(this.apiUrl, session);
  }

  updateSession(session: Session): Observable<Session> {
    const url = `${this.apiUrl}/${session.id}`;
    return this.http.put<Session>(url, session).pipe(
      catchError((error: HttpErrorResponse) => {
        console.log(error);
        return throwError('An error occurred while updating the session.');
      })
    );
  }

  deleteSession(sessionId: number): Observable<void> {
    const url = `${this.apiUrl}/${sessionId}`;
    return this.http.delete<void>(url).pipe(
      catchError((error: HttpErrorResponse) => {
        console.log(error);
        return throwError('An error occurred while deleting the session.');
      })
    );
  }
}
