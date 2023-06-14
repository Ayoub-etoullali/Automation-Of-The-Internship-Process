import { Component, OnInit } from '@angular/core';
import { OffreDeStage } from '../../../model/OffreDeStage';
import { OffreDeStageService } from '../../../services/offre-de-stage/offre-de-stage.service';
import Swal from 'sweetalert2';
import { Router } from "@angular/router";
import { FormBuilder } from "@angular/forms";
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-offre-de-stage',
  templateUrl: './offre-de-stage.component.html',
  styleUrls: ['./offre-de-stage.component.css']
})
export class OffreDeStageComponent implements OnInit {
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
    this.offreDeStageService.getAllOffreDeStages().subscribe(
      offresDeStage => {
        this.offresDeStage = offresDeStage;
      },
      error => {
        console.log(error);
      }
    );
  }

  handleDeleteButton(offreDeStage: OffreDeStage) {
    Swal.fire({
      title: 'Are you sure you want to delete this Offre de Stage?',
      showCancelButton: true,
      confirmButtonText: 'Yes',
      denyButtonText: 'No',
    }).then((result) => {
      if (result.isConfirmed) {
        this.offreDeStageService.deleteOffreDeStage(offreDeStage.id).subscribe({
          next: (resp) => {
            Swal.fire('Deleted successfully!', '');
          },
          error: (err) => {
            console.log(err);
          }
        });
      }
    });
  }

  goToUpdate(offreDeStage: OffreDeStage) {
    this.offreDeStageService.updateOffreDeStage(offreDeStage.id, offreDeStage);
    this.router.navigateByUrl("/update-offre/" + offreDeStage.id);
  }

  goToAdd() {
    this.router.navigateByUrl("/add-offre");
  }

  goToDetails(offreDeStage: OffreDeStage): void {
    this.router.navigateByUrl('/details/' + offreDeStage.id);
  }

  handleLogout() {
    this.auth.logout();
    this.roles = null;
    this.router.navigateByUrl("/login");
  }
}
