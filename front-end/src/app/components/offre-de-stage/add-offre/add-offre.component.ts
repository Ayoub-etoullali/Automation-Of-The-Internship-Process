import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import Swal from 'sweetalert2';
import { OffreDeStage } from "../../../model/OffreDeStage";
import { OffreDeStageService } from "../../../services/offre-de-stage/offre-de-stage.service";
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-add-offre',
  templateUrl: './add-offre.component.html'
})
export class AddOffreDeStageComponent implements OnInit {

  newOffreDeStageFormGroup!: FormGroup;
  roles!: string | null;
  customerId: any;

  constructor(private fb: FormBuilder, private offreDeStageService: OffreDeStageService, private router: Router, private auth: AuthService) {
  }

  ngOnInit(): void {
    this.roles = localStorage.getItem("ROLES");
    if (localStorage.getItem("id") != undefined) {
      this.customerId = localStorage.getItem("id");
    }
    this.newOffreDeStageFormGroup = this.fb.group({
      poste: [null, Validators.required],
      entreprise: [null, Validators.required],
      description: [null, Validators.required],
      dateDebut: [null, Validators.required],
      dateFin: [null, Validators.required],
      technologie: [null, Validators.required]
    });
  }

  addOffreDeStage() {
    let offreDeStage: OffreDeStage = this.newOffreDeStageFormGroup.value;
    this.offreDeStageService.createOffreDeStage(offreDeStage).subscribe(
      data => {
        Swal.fire({
          position: 'center',
          title: "Offre de Stage successfully saved!",
          showConfirmButton: false,
          timer: 1500
        });
        this.newOffreDeStageFormGroup.reset();
      },
      err => {
        Swal.fire({
          position: 'center',
          icon: 'error',
          title: err.message,
          showConfirmButton: false,
          timer: 1500
        });
      }
    );
  }

  OnResetedForm(){
    this.newOffreDeStageFormGroup.reset()
  }

  handleLogout() {
    this.auth.logout();
    this.roles = null;
    this.router.navigateByUrl("/login");
  }
}
