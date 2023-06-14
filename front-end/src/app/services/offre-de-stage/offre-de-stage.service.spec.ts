import { TestBed } from '@angular/core/testing';

import { OffreDeStageService } from './offre-de-stage.service';

describe('OffreDeStageService', () => {
  let service: OffreDeStageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OffreDeStageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
