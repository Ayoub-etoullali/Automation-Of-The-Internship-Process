import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewProjetComponent } from './new-projet.component';

describe('NewCustomerComponent', () => {
  let component: NewProjetComponent;
  let fixture: ComponentFixture<NewProjetComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewProjetComponent]
    });
    fixture = TestBed.createComponent(NewProjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
