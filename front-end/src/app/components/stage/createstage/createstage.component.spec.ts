import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatestageComponent } from './createstage.component';

import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Stage} from "../../../model/Stage.model";
import {EtudiantService} from "../../../services/etudiant/etudiant.service";

describe('CreatestageComponent', () => {
  let component: CreatestageComponent;
  let fixture: ComponentFixture<CreatestageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreatestageComponent]
    });
    fixture = TestBed.createComponent(CreatestageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
