import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OffresStageComponent } from './offres-stage.component';

describe('OffresStageComponent', () => {
  let component: OffresStageComponent;
  let fixture: ComponentFixture<OffresStageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OffresStageComponent]
    });
    fixture = TestBed.createComponent(OffresStageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
