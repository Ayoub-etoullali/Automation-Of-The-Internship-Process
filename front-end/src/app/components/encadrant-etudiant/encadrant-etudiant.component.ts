import { Component, OnInit } from '@angular/core';
import {EncadrantEtudiantService} from "../../services/encadrant_etudiant/encadrant-etudiant.service";
import { ActivatedRoute, Router } from "@angular/router";
import { EncadrantEtudiant } from "../../model/encadrant-etudiant";
import { Stage } from "../../model/stage";
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-encadrant-etudiant',
  templateUrl: './encadrant-etudiant.component.html',
  styleUrls: ['./encadrant-etudiant.component.css']
})
export class EncadrantEtudiantComponent implements OnInit {
  roles!: string | null;
  customerId: any;
  stageId!: string;
  stage!: Stage;
  etudiants: EncadrantEtudiant[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private encadrantEtudiantService: EncadrantEtudiantService,
    private auth: AuthService
  ) {
    this.stageId = this.route.snapshot.params['id'];
    this.stage = this.router.getCurrentNavigation()?.extras.state as Stage;
  }

  ngOnInit(): void {
    this.roles = localStorage.getItem("ROLES");
    if (localStorage.getItem("id") != undefined) {
      this.customerId = localStorage.getItem("id");
    }
    this.encadrantEtudiantService.getEtudiant(parseInt(this.stageId)).subscribe({
      next: (etudiant: EncadrantEtudiant) => {
        console.log(etudiant);
        if (etudiant) {
          this.etudiants = [etudiant];
        }
      },
      error: (err: any) => {
        console.log(err);
      }
    });
  }

  ViewSESSION(etudiant: EncadrantEtudiant) {
    this.router.navigateByUrl("/session/" + etudiant.id + "?etudiantId=" + etudiant.id);
  }

  handleLogout() {
    this.auth.logout();
    this.roles = null;
    this.router.navigateByUrl("/login");
  }
}
