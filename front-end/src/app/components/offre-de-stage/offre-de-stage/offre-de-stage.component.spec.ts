import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OffreDeStageComponent } from './offre-de-stage.component';

describe('OffreDeStageComponent', () => {
  let component: OffreDeStageComponent;
  let fixture: ComponentFixture<OffreDeStageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OffreDeStageComponent]
    });
    fixture = TestBed.createComponent(OffreDeStageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
