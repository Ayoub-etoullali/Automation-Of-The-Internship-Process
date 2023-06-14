import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {OffreStage} from "../../model/OffreStage.model";
import {catchError, Observable, throwError} from "rxjs";
import {Postes} from "../../model/Postes.model";
import {AuthenticationService} from "../../services/authentication/authentication.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Projet} from "../../model/Projet.model";
import {ForumService} from "../../services/forum/forum.service";

@Component({
  selector: 'app-home-page',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {
  PostesObservable!: Observable<Array<Postes>>;
  searchFormGroup!: FormGroup;
  errorMsg!: String;


  constructor(public authService: AuthenticationService, private posteService: ForumService, private formBuilder: FormBuilder, private router: Router) {
  }


  ngOnInit(): void {

    this.searchFormGroup = this.formBuilder.group({
      keyword: this.formBuilder.control(""),
      keyword1: this.formBuilder.control("")
    });
    this.Postes();
    /** Pagination*
     * this.offreFormGroup=this.formBuilder.group({
     *       accountId : this.formBuilder.control('')
     *     });
     */

  }

  Details(postes: Postes) {
    this.router.navigateByUrl("/detail-postes/" + postes.id, {state: postes});
  }

  private Postes() {
    this.PostesObservable = this.posteService.Postes().pipe(
      catchError(err => {
        this.errorMsg = err.message;
        return throwError(err)
      })
    );
  }

  handleSearchPostesByTags() {
    let kw = this.searchFormGroup.value.keyword; // add ?
    this.PostesObservable = this.posteService.searchPosteByTag(kw).pipe(
      catchError(err => {
        this.errorMsg = err.message;
        return throwError(err)
      })
    );
  }

  handleSearchPostesByTitre() {
    let kw = this.searchFormGroup.value.keyword1; // add ?
    this.PostesObservable = this.posteService.searchPosteByTitre(kw).pipe(
      catchError(err => {
        this.errorMsg = err.message;
        return throwError(err)
      })
    );
  }

  Reset() {
    this.Postes();
    this.searchFormGroup = this.formBuilder.group({
      keyword: this.formBuilder.control(""),
      keyword1: this.formBuilder.control("")
    });
  }
}
