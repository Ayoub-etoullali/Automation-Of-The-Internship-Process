import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {OffreStage} from "../../../model/OffreStage.model";
import {Postes} from "../../../model/Postes.model";

@Component({
  selector: 'app-customer-accounts',
  templateUrl: './details-postes.component.html',
  styleUrls: ['./details-postes.component.css']
})
export class DetailsPostesComponent implements OnInit {
  postesId! : number ;
  postes! : Postes;
  constructor(private route : ActivatedRoute, private router :Router) {
    this.postes=this.router.getCurrentNavigation()?.extras.state as Postes;
  }

  ngOnInit(): void {
    this.postesId = this.route.snapshot.params['id'];
  }

}
