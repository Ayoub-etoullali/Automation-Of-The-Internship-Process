import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValidateOffreComponent } from './validate-offre.component';

describe('ValidateOffreComponent', () => {
  let component: ValidateOffreComponent;
  let fixture: ComponentFixture<ValidateOffreComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ValidateOffreComponent]
    });
    fixture = TestBed.createComponent(ValidateOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
