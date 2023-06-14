import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateSessionComponent } from './update-session.component';

describe('UpdateSessionComponent', () => {
  let component: UpdateSessionComponent;
  let fixture: ComponentFixture<UpdateSessionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateSessionComponent]
    });
    fixture = TestBed.createComponent(UpdateSessionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
