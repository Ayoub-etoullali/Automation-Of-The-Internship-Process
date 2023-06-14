import {Injectable} from '@angular/core';
import {AppUser} from "../../model/user.model";
// @ts-ignore
import * as uuid from "uuid";
import {Observable, of, throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  users: AppUser[] = [];
  authenticatedUser: AppUser | undefined;

  constructor() {
    this.users.push({userId: uuid.v4(), username: "radouan", password: "radouan"})
    this.users.push({userId: uuid.v4(), username: "ihssan", password: "ihssan"})
    this.users.push({userId: uuid.v4(), username: "ayoub", password: "ayoub"})
  }

  public login(username: string, password: string): Observable<AppUser> {
    let appUser = this.users.find(u => u.username == username);
    if (!appUser) return throwError(() => new Error("User not found"));
    if (appUser.password != password) return throwError(() => new Error("Bad Credentials"));
    return of(appUser);
  }

  public authenticateUser(appUser: AppUser): Observable<boolean> {
    this.authenticatedUser = appUser;
    localStorage.setItem("authUser", JSON.stringify({
      username: appUser.username,
      password: appUser.password,
      jwt: "JWT_TOKEN"
    }))
    return of(true);
  }

  public isAuthenticated(){
    return this.authenticatedUser!=undefined;
  }

  public logout(): Observable<boolean>{
    this.authenticatedUser=undefined;
    localStorage.removeItem("authUser");
    return of(true);
  }
}
