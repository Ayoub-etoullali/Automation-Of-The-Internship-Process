import { Component, OnInit } from '@angular/core';
import {Session} from "../../model/session";
import {SessionService} from "../../services/session/session.service";
import Swal from 'sweetalert2';
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder} from "@angular/forms";
import {EncadrantEtudiant} from "../../model/encadrant-etudiant";
import {EncadrantEtudiantService} from "../../services/encadrant_etudiant/encadrant-etudiant.service";
import {Stage} from "../../model/stage";
import {Etudiant} from "../../model/Etudiant.model";
import {AuthService} from "../../services/auth.service";


@Component({
  selector: 'app-session',
  templateUrl: './session.component.html',
  styleUrls: ['./session.component.css']
})
export class SessionComponent implements OnInit {
  etudiantId!: string;
  etudiant!: EncadrantEtudiant;
  sessions: Session[] = [];
  roles!: string | null;
  customerId: any;


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private encadrantEtudiantService: EncadrantEtudiantService,
    private sessionService: SessionService,
    private auth: AuthService
  ) {

  }

  ngOnInit(): void {
    this.roles = localStorage.getItem("ROLES");
    if (localStorage.getItem("id") != undefined) {
      this.customerId = localStorage.getItem("id");
    }
    this.etudiantId = this.route.snapshot.params['id'];
    this.etudiant = this.router.getCurrentNavigation()?.extras.state as Etudiant;
    const etudiantIdNumber = parseInt(this.etudiantId);

    if (!isNaN(etudiantIdNumber)) {
      this.sessionService.getSessionsByEtudiantId(etudiantIdNumber).subscribe({
        next: (sessions: Session[]) => {
          console.log(sessions);
          this.sessions = sessions;
        },
        error: (err: any) => {
          console.log(err);
        }
      });
    }
  }

  goToUpdate(session: Session) {
    this.sessionService.updateSession(session)
    this.router.navigateByUrl("/update-session/" + session.id);
  }
  gotoadd() {
    this.router.navigateByUrl("/add-session");
  }

  handleDeleteButton(session: Session) {
    Swal.fire({
      title: 'Are you sure?',
      text: 'This action cannot be undone!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.sessionService.deleteSession(session.id).subscribe(
          () => {
            Swal.fire(
              'Deleted!',
              'The session has been deleted.',
              'success'
            );
            // Refresh the session list
            this.sessionService.getSessionsByEtudiantId(parseInt(this.etudiantId)).subscribe(
              (sessions: Session[]) => {
                this.sessions = sessions;
              },
              (error: any) => {
                console.log(error);
              }
            );
          },
          (error: any) => {
            console.log(error);
            Swal.fire(
              'Error!',
              'An error occurred while deleting the session.',
              'error'
            );
          }
        );
      }
    });
  }

  handleLogout() {
    this.auth.logout();
    this.roles = null;
    this.router.navigateByUrl("/login");
  }
}
