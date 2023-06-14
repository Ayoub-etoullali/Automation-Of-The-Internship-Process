import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsPostesComponent } from './details-postes.component';

describe('CustomerAccountsComponent', () => {
  let component: DetailsPostesComponent;
  let fixture: ComponentFixture<DetailsPostesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsPostesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsPostesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
