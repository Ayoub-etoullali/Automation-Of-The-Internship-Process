import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditEtudiantComponent } from './edit-etudiant.component';

describe('EditCustomerComponent', () => {
  let component: EditEtudiantComponent;
  let fixture: ComponentFixture<EditEtudiantComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditEtudiantComponent]
    });
    fixture = TestBed.createComponent(EditEtudiantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
