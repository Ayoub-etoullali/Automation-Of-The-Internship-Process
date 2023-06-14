import { Component } from '@angular/core';
import {Etudiant} from "../../model/Etudiant.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-etudiants',
  templateUrl: './etudiant.component.html',
  styleUrls: ['./etudiant.component.css']
})
export class EtudiantComponent {
constructor(private router:Router) {
}
  Edit() {
    this.router.navigateByUrl("/navbar/edit-etudiant/"+1);
  }
}
