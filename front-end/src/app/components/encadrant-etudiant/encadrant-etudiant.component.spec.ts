import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EncadrantEtudiantComponent } from './encadrant-etudiant.component';

describe('EncadrantEtudiantComponent', () => {
  let component: EncadrantEtudiantComponent;
  let fixture: ComponentFixture<EncadrantEtudiantComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EncadrantEtudiantComponent]
    });
    fixture = TestBed.createComponent(EncadrantEtudiantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
