import {Component, OnInit} from '@angular/core';
import {catchError, Observable, throwError} from "rxjs";
import {FormBuilder, FormGroup} from "@angular/forms";
import {AuthenticationService} from "../../services/authentication/authentication.service";
import {OffresStageService} from "../../services/offres-stage/offres-stage.service";
import {Router} from "@angular/router";
import {OffreStage, OffreStageDetails} from "../../model/OffreStage.model";
import {OffreDeStage} from "../../model/OffreDeStage";
import {OffreDeStageService} from "../../services/offre-de-stage/offre-de-stage.service";
import {AuthService} from "../../services/auth.service";
import Swal from "sweetalert2";

@Component({
  selector: 'app-offres-stage',
  templateUrl: './offres-stage.component.html',
  styleUrls: ['./offres-stage.component.css']
})
export class OffresStageComponent implements OnInit {
  offresStageObservable!: Observable<Array<OffreStage>>;
  offreStageObservable! : Observable<OffreStageDetails>
  errorMsg!: String;
  currentPage : number =0;
  pageSize : number =5;
  offreFormGroup! : FormGroup;
  searchFormGroup!: FormGroup;
  roles!: string | null;
  customerId: any;
  offresDeStage: OffreDeStage[] = [];


  constructor(private offresStageService: OffreDeStageService, private fb: FormBuilder,
              private router: Router, private auth: AuthService,
              public  authService : AuthenticationService,
              private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {

    this.searchFormGroup = this.formBuilder.group({
      keyword: this.formBuilder.control("")
    });
    this.OffresStage();
    this.roles = localStorage.getItem("ROLES");
    if (localStorage.getItem("id") != undefined) {
      this.customerId = localStorage.getItem("id");
    }
    this.getOffresDeStage();
    /** Pagination*
     * this.offreFormGroup=this.formBuilder.group({
     *       accountId : this.formBuilder.control('')
     *     });
     */

  }

  handleSearchOffresStageByPoste() {
    let kw = this.searchFormGroup.value.keyword; // add ?
    this.offresStageObservable = this.offresStageService.searchOffresStageByPoste(kw).pipe(
      catchError(err => {
        this.errorMsg = err.message;
        return throwError(err)
      })
    );
  }


  Details(offreStage: OffreStage) {
    this.router.navigateByUrl("/navbar/details-offre-stage/"+offreStage.id,{state :offreStage});
  }

  private OffresStage() {
    this.offresStageObservable = this.offresStageService.OffresStage().pipe(
      catchError(err => {
        this.errorMsg = err.message;
        return throwError(err)
      })
    );
  }

  Postuler(o: any) {

  }

  /**page**/
  /*
  gotoPage(page: number) {
    this.currentPage=page;
    this.handleSearchAccount();
  }
  handleSearchAccount() {
    let accountId : string =this.offreFormGroup.value.accountId;
    this.offreStageObservable=this.offresStageService.getAccount(accountId,this.currentPage, this.pageSize).pipe(
      catchError(err => {
        this.errorMsg=err.message;
        return throwError(err);
      })
    );
  }
   */

  getOffresDeStage(): void {
    this.offresStageService.getAllOffreDeStages().subscribe(
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
        this.offresStageService.deleteOffreDeStage(offreDeStage.id).subscribe({
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
    this.offresStageService.updateOffreDeStage(offreDeStage.id, offreDeStage);
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

  Reset() {
    this.OffresStage();
    this.searchFormGroup = this.formBuilder.group({
      keyword: this.formBuilder.control(""),
      keywords: this.formBuilder.control(""),
    });
  }
  public handleSetPostuler(o: OffreStage) {
    let pos = o.postuler;
    this.offresStageService.setPostuler(o).subscribe({
      next: () => {
        o.postuler = !pos;
      },
      error: (err) => {
        this.errorMsg = err;
      }
    })
  }
}
