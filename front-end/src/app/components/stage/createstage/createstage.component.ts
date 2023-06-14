import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {ActivatedRoute, Router} from "@angular/router";
import {StageService} from "../../../services/stageservice/stage.service";

@Component({
  selector: 'app-add-stage',
  templateUrl: './createstage.component.html',
  styleUrls: ['./createstage.component.css']
})
export class CreatestageComponent implements OnInit {
  createStageFormGroup!: FormGroup;

  constructor(
    private fb: FormBuilder,
    public stageService: StageService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.createStageFormGroup = this.fb.group({
      titre: this.fb.control(''),
      description: this.fb.control(''),
      utite_d_accueil: this.fb.control(''),
      date_debut: this.fb.control(''),
      date_fin: this.fb.control('')
    });
  }
  onSubmit(): void {
    if (this.createStageFormGroup.invalid) {
      return;
    }

    const stageData = this.createStageFormGroup.value;

    this.stageService.createStage(stageData).subscribe(
      response => {
        console.log('Stage created successfully', response);
      },
      error => {
        console.error('Error creating stage', error);
      }
    );
  }
}
