import { TestBed } from '@angular/core/testing';

import { OffresStageService } from './offres-stage.service';

describe('OffresStageService', () => {
  let service: OffresStageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OffresStageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
