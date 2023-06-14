import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {OffreStage} from "../../../model/OffreStage.model";

@Component({
  selector: 'app-customer-accounts',
  templateUrl: './details-offre-stage.component.html',
  styleUrls: ['./details-offre-stage.component.css']
})
export class DetailsOffreStageComponent implements OnInit {
  offreStageId! : number ;
  offreStage! : OffreStage;
  constructor(private route : ActivatedRoute, private router :Router) {
    this.offreStage=this.router.getCurrentNavigation()?.extras.state as OffreStage;
  }

  ngOnInit(): void {
    this.offreStageId = this.route.snapshot.params['id'];
  }

}
