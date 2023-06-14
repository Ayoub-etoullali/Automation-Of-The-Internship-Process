import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Projet} from "../../../model/Projet.model";
import {ProjetsService} from "../../../services/projets/projets.service";

@Component({
  selector: 'app-edit-projet',
  templateUrl: './edit-projet.component.html',
  styleUrls: ['./edit-projet.component.css']
})
export class EditProjetComponent implements OnInit {
  projetId!: number;
  editProjetFormGroup!: FormGroup;
  projet!: Projet;


  constructor(private fb: FormBuilder, public projetsService: ProjetsService, private route: ActivatedRoute, private router: Router) { //route : pour obtient le id qui est dans la route
    this.projetId = this.route.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.projetsService.getProjet(this.projetId).subscribe({
      next: (projet) => {
        this.projet = projet;
        this.editProjetFormGroup = this.fb.group({
          intitule: this.fb.control(this.projet.intitule, [Validators.required, Validators.minLength(4)]),
          description: this.fb.control(this.projet.description, [Validators.required]),
          path: this.fb.control(this.projet.path, [Validators.required]),
          stageDTO: this.fb.control(this.projet.stageDTO, [Validators.required])
        });
      }, error: err => {
        console.log(err);
      }
    })
  }

  handleUpdateCustomer() {
    let projet = this.editProjetFormGroup.value;
    projet.id = this.projet.id;
    this.projetsService.updateEtudiant(projet).subscribe({
      next: (data) => {
        alert("Projet edited successfully")
        this.router.navigateByUrl("/projets")
      },
      error: err => {
        console.log(err)
      }
    });
  }
}
