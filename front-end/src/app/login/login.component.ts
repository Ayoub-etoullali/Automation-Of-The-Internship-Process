// import {Component, OnInit} from '@angular/core';
// import {FormBuilder, FormGroup} from "@angular/forms";
// import {AuthenticationService} from "../services/authentication/authentication.service";
// import {Router} from "@angular/router";
//
// @Component({
//   selector: 'app-login',
//   templateUrl: './login.component.html',
//   styleUrls: ['./login.component.css']
// })
// export class LoginComponent implements OnInit {
//   userFormGroup!: FormGroup;
//   errorMessage!: string;
//
//   constructor(private formBuilder: FormBuilder,
//               private authenticationService: AuthenticationService,
//               private router: Router) {
//   }
//
//   ngOnInit(): void {
//     this.userFormGroup = this.formBuilder.group({
//       username: this.formBuilder.control(""),
//       password: this.formBuilder.control("")
//     })
//   }
//
//   handleLogin() {
//     let username = this.userFormGroup.value.username;
//     let password = this.userFormGroup.value.password;
//     this.authenticationService.login(username, password).subscribe({
//       next: (appUser) => {
//         this.authenticationService.authenticateUser(appUser).subscribe({
//           next: (data) => {
//             this.router.navigateByUrl("/navbar/acceuil");
//           }
//         });
//       },
//       error: (err) => {
//         this.errorMessage = err;
//       }
//     })
//   }
// }

import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder} from '@angular/forms';
import {Router} from '@angular/router';
import {AuthService} from "../services/auth.service";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  constructor(private authService: AuthService, private formBuilder: FormBuilder, private router: Router) {
  }
  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: [''],
      password: ['']
    });
  }
  get f() {
    return this.loginForm.controls;
  }
  login() {
    this.authService.login(
      {
        username: this.f['username'   ].value,
        password: this.f['password'].value
      }
    )
      // .subscribe(success => {
      //   if (success) {
      //     if (localStorage.getItem("ROLES")!.includes("ADMIN")) {
      //       this.router.navigate(['/navbar/acceuil']);
      //       document.location.reload();
      //     } else {
      //       this.router.navigate(["/navbar/acceuil"]);
      //       setTimeout(function () {
      //         document.location.reload();
      //       }, 1000);
      //     }
      //   }
      // });
      .subscribe(success => {
        if (success) {
          this.router.navigate(['/dashboard']);
          document.location.reload();
        }
      });
  }
}
