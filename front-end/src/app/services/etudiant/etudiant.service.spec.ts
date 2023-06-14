import { TestBed } from '@angular/core/testing';

import { EtudiantService } from './etudiant.service';

describe('EtudiantsService', () => {
  let service: EtudiantService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EtudiantService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
