import { Component, OnInit } from '@angular/core';
import { OffreDeStage } from '../../../model/OffreDeStage';
import { OffreDeStageService } from '../../../services/offre-de-stage/offre-de-stage.service';
import Swal from 'sweetalert2';
import { Router } from "@angular/router";
import { FormBuilder } from "@angular/forms";
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-offre-de-stage',
  templateUrl: './validate-offre.component.html'
})
export class ValidateOffreComponent implements OnInit {
  roles!: string | null;
  customerId: any;
  offresDeStage: OffreDeStage[] = [];

  constructor(private offreDeStageService: OffreDeStageService, private fb: FormBuilder, private router: Router, private auth: AuthService) { }

  ngOnInit() {
    this.roles = localStorage.getItem("ROLES");
    if (localStorage.getItem("id") != undefined) {
      this.customerId = localStorage.getItem("id");
    }
    this.getOffresDeStage();
  }

  getOffresDeStage(): void {
    this.offreDeStageService.getNonValideOffresDeStage().subscribe(
      offresDeStage => {
        this.offresDeStage = offresDeStage;
      },
      error => {
        console.log(error);
      }
    );
  }

  handleRefuseButton(offreDeStage: OffreDeStage) {
    Swal.fire({
      title: 'Are you sure you want to delete this Offre de Stage?',
      showCancelButton: true,
      confirmButtonText: 'Yes',
      denyButtonText: 'No',
    }).then((result) => {
      if (result.isConfirmed) {
        this.offreDeStageService.deleteOffreDeStage(offreDeStage.id).subscribe({
          next: (resp) => {
            Swal.fire('Refused successfully!', '');
          },
          error: (err) => {
            console.log(err);
          }
        });
      }
    });
  }

  handleValidateButton(offreDeStage: OffreDeStage) {
    offreDeStage.validated = true; // Set the validated property to true

    this.offreDeStageService.updateOffreDeStage(offreDeStage.id, offreDeStage).subscribe(
      () => {
        // Success
        console.log('Offre de stage updated successfully');
      },
      (error) => {
        // Handle error
        console.error('Error updating offre de stage', error);
      }
    );
  }

  goToDetails(offreDeStage: OffreDeStage): void {
    this.router.navigate(['/details', offreDeStage.id]);
  }

  handleLogout() {
    this.auth.logout();
    this.roles = null;
    this.router.navigateByUrl("/login");
  }
}
