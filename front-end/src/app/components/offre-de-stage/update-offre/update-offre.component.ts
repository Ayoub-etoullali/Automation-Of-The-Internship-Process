import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import Swal from "sweetalert2";
import { OffreDeStageService } from "../../../services/offre-de-stage/offre-de-stage.service";
import { ActivatedRoute, Router } from "@angular/router";
import { OffreDeStage } from "../../../model/OffreDeStage";
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-update-offre',
  templateUrl: './update-offre.component.html'
})
export class UpdateOffreDeStageComponent implements OnInit {
  updateFormGroup!: FormGroup;
  roles!: string | null;
  customerId: any;
  constructor(
    private fb: FormBuilder,
    private offreDeStageService: OffreDeStageService,
    private route: ActivatedRoute,
    private router: Router,
    private auth: AuthService
  ) {}

  ngOnInit(): void {
    this.roles = localStorage.getItem("ROLES");
    if (localStorage.getItem("id") != undefined) {
      this.customerId = localStorage.getItem("id");
    }
    this.updateFormGroup = this.fb.group({
      poste: [null, Validators.required],
      entreprise: [null, Validators.required],
      description: [null, Validators.required],
      dateDebut: [null, Validators.required],
      dateFin: [null, Validators.required],
      technologie: [null, Validators.required]
    });
    this.getOffreDeStage();
  }

  update() {
    if (this.updateFormGroup.valid) {
      const offreDeStage: OffreDeStage = this.updateFormGroup.value;
      offreDeStage.id = +this.route.snapshot.params['id'];
      this.offreDeStageService.updateOffreDeStage(offreDeStage.id, offreDeStage).subscribe(
        {
          next: data => {
            Swal.fire({
              position: 'center',
              title: "Successfully updated!",
              showConfirmButton: false,
              timer: 1500
            });
          },
          error: err => {
            // Handle error
          }
        }
      );
    }
  }

  private getOffreDeStage() {
    const offreDeStageId = +this.route.snapshot.params['id'];
    this.offreDeStageService.getOffreDeStageById(offreDeStageId).subscribe(
      {
        next: data => {
          this.updateFormGroup.patchValue({
            poste: data.poste,
            entreprise: data.entreprise,
            description: data.description,
            dateDebut: data.dateDebut,
            dateFin: data.dateFin,
            technologie: data.technologie
          });
        },
        error: err => {
          // Handle error
        }
      }
    );
  }

  OnResetedForm(){
    this.updateFormGroup.reset()
  }

  handleLogout() {
    this.auth.logout();
    this.roles = null;
    this.router.navigateByUrl("/login");
  }
}
