import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsOffreComponent } from './details-offre.component';

describe('DetailsOffreComponent', () => {
  let component: DetailsOffreComponent;
  let fixture: ComponentFixture<DetailsOffreComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetailsOffreComponent]
    });
    fixture = TestBed.createComponent(DetailsOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
