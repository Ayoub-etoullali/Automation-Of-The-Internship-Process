import { Component } from '@angular/core';
import {Router} from "@angular/router";
import { RouterModule } from '@angular/router';


@Component({
  selector: 'app-stage',
  templateUrl: './stage.component.html',
  styleUrls: ['./stage.component.css']
})
export class StageComponent {
  constructor(private router:Router) {
  }
  Create() {
    this.router.navigateByUrl("/navbar/createstage/"+1);
  }

}
