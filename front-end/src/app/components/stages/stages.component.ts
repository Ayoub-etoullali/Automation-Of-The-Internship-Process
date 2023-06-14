import { Component, OnInit } from '@angular/core';
import { StageService } from "../../services/stages/stage.service";
import { ActivatedRoute, Router } from "@angular/router";
import { Stage } from "../../model/stage";
import { Etudiant } from "../../model/Etudiant.model";
import { EncadrantEtudiantService } from "../../services/encadrant_etudiant/encadrant-etudiant.service";
import {AuthService} from "../../services/auth.service";


@Component({
  selector: 'app-stages',
  templateUrl: './stages.component.html',
  styleUrls: ['./stages.component.css']
})
export class StagesComponent implements OnInit {
  roles!: string | null;
  stages: Stage[] = [];
  stageId: any;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private stageService: StageService,
    private encadrantEtudiantService: EncadrantEtudiantService,
    private auth: AuthService
  ) {
  }

  etudiant!: Etudiant;

  ngOnInit(): void {
    this.roles = localStorage.getItem("ROLES");
    if (localStorage.getItem("id") != undefined) {
      this.stageId = localStorage.getItem("id");
    }
    this.getStages();
  }

  getStages(): void {
    this.stageService.getStages().subscribe(
      stages => {
        this.stages = stages;
      },
      error => {
        console.log(error);
      }
    );
  }

  viewEtudiant(stage: Stage) {
    this.router.navigateByUrl('/encadrant-etudiant/' + stage.id, {state: stage});
  }
  Details(stage: Stage) {
    this.router.navigateByUrl('/encadrant-etudiant/' + stage.id, { state: stage });
  }
  handleLogout() {
    this.auth.logout();
    this.roles = null;
    this.router.navigateByUrl("/login");
  }
}
