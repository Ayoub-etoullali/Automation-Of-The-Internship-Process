import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { of, Observable } from 'rxjs';
import { catchError, mapTo, tap } from 'rxjs/operators';
import {Tokens} from "../model/tokens";
import {environment} from "../../environments/environment";
import {Router} from "@angular/router";
import Swal from "sweetalert2";
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly JWT_TOKEN = 'JWT_TOKEN';
  private readonly REFRESH_TOKEN = 'REFRESH_TOKEN';
  private readonly ROLES = 'ROLES';
  private loggedUser!: string;
  constructor(private http: HttpClient,private router:Router) {}
  login(user: { username: string, password: string }): Observable<boolean> {
    return this.http.post<any>(environment.apiUrl+'/login', user)
      .pipe(
        tap(tokens => this.doLoginUser(user.username, tokens)),
        mapTo(true),
        catchError(error => {
          Swal.fire({
            position: 'center',
            icon: 'error',
            title: "The given information are incorrect, please try again !",
            showConfirmButton: false,
            timer: 2500
          });
          return of(false);
        }));
  }
  logout() {
    this.doLogoutUser()
  }

  isLoggedIn() {
    return !!this.getJwtToken();
  }
  refreshToken() {
    return this.http.post<any>(environment.apiUrl+'/refresh', {
      'refreshToken': this.getRefreshToken()
    }).pipe(tap((tokens: Tokens) => {
      this.storeJwtToken(tokens.jwt,tokens.roles);
    }));
  }
  getJwtToken() {
    return localStorage.getItem(this.JWT_TOKEN);
  }
  private doLoginUser(username: string, tokens: Tokens) {
    this.loggedUser = username;
    this.storeTokens(tokens);
  }
  private doLogoutUser() {
    this.loggedUser = 'null';
    this.removeTokens();
  }
  private getRefreshToken() {
    return localStorage.getItem(this.REFRESH_TOKEN);
  }
  private storeJwtToken(jwt: string,roles:string) {
    localStorage.setItem(this.JWT_TOKEN, jwt);
    localStorage.setItem(this.ROLES,roles);
    localStorage.setItem("id","1");
  }
  private storeTokens(tokens: Tokens,) {
    localStorage.setItem(this.JWT_TOKEN, tokens.jwt);
    localStorage.setItem(this.REFRESH_TOKEN, tokens.refreshToken);
    localStorage.setItem(this.ROLES,tokens.roles);
    localStorage.setItem("id","1");

  }
  private removeTokens() {
    localStorage.removeItem(this.JWT_TOKEN);
    localStorage.removeItem(this.REFRESH_TOKEN);
    localStorage.removeItem(this.ROLES);
    localStorage.removeItem("id");
  }
}
