import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Etudiant} from "../../../model/Etudiant.model";
import {EtudiantService} from "../../../services/etudiant/etudiant.service";

@Component({
  selector: 'app-edit-projet',
  templateUrl: './edit-etudiant.component.html',
  styleUrls: ['./edit-etudiant.component.css']
})
export class EditEtudiantComponent implements OnInit {
  editEtudiantFormGroup!: FormGroup;
  etudiant!: Etudiant;


  constructor(private fb: FormBuilder, public etudiantService: EtudiantService, private route: ActivatedRoute, private router: Router) { //route : pour obtient le id qui est dans la route
  }

  ngOnInit(): void {
    this.etudiantService.getEtudiant(1).subscribe({
      next: (etudiant) => {
        this.etudiant = etudiant;
        this.editEtudiantFormGroup  = this.fb.group({
          nom: this.fb.control(this.etudiant.nom),
          prenom: this.fb.control(this.etudiant.prenom),
          username: this.fb.control(this.etudiant.username),
          password: this.fb.control(this.etudiant.password),
          email: this.fb.control(this.etudiant.email),
          telephone: this.fb.control(this.etudiant.telephone),
          adresse: this.fb.control(this.etudiant.adresse),
          filiere: this.fb.control(this.etudiant.filiere),
          cin: this.fb.control(this.etudiant.cin),
          cne: this.fb.control(this.etudiant.cne),
        });
      }, error: err => {
        console.log(err);
      }
    })
  }

  handleUpdateProjet() {
    let etudiant = this.editEtudiantFormGroup.value;
    etudiant.id = this.etudiant.id;
    this.etudiantService.updateEtudiant(etudiant).subscribe({
      next: (data) => {
        alert("Projet edited successfully")
        this.router.navigateByUrl("/navbar/etudiant")
      },
      error: err => {
        console.log(err)
      }
    });
  }
}
