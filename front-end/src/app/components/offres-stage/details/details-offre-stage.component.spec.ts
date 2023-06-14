import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsOffreStageComponent } from './details-offre-stage.component';

describe('CustomerAccountsComponent', () => {
  let component: DetailsOffreStageComponent;
  let fixture: ComponentFixture<DetailsOffreStageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsOffreStageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsOffreStageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
