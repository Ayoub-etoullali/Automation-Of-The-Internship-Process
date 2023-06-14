import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) { }
  // canActivate() {
  //   if (this.authService.isLoggedIn()) {
  //     this.router.navigate(['/navbar/acceuil']);
  //   }
  //   return !this.authService.isLoggedIn();
  // }
  canActivate() {
    if (this.authService.isLoggedIn()) {
      this.router.navigate(['/dashboard']);
    }
    return !this.authService.isLoggedIn();
  }
}
