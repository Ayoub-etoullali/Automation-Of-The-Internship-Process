import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OffreDeStage } from '../../../model/OffreDeStage';
import { OffreDeStageService } from '../../../services/offre-de-stage/offre-de-stage.service';
import { AuthService } from '../../../services/auth.service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-details-offre',
  templateUrl: './details-offre.component.html',
  styleUrls: ['./details-offre.component.css']
})
export class DetailsOffreComponent implements OnInit {
  offreDeStage!: OffreDeStage;
  roles!: string | null;
  customerId: any;
  constructor(
    private route: ActivatedRoute,
    private offreDeStageService: OffreDeStageService,
    private auth: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.roles = localStorage.getItem("ROLES");
    if (localStorage.getItem("id") != undefined) {
      this.customerId = localStorage.getItem("id");
    }
    this.getOffreDeStageDetails();
  }

  getOffreDeStageDetails(): void {
    const id = this.route.snapshot.paramMap.get('id');

    if (id) {
      const numericId = +id; // Convert id from string to number

      this.offreDeStageService.getOffreDeStageById(numericId)
        .subscribe(offreDeStage => {
          this.offreDeStage = offreDeStage;
        });
    }
  }

  handleLogout() {
    this.auth.logout();
    this.roles = null;
    this.router.navigateByUrl("/login");
  }
}
