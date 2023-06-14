import { TestBed } from '@angular/core/testing';

import { EncadrantEtudiantService } from './encadrant-etudiant.service';

describe('EncadrantEtudiantService', () => {
  let service: EncadrantEtudiantService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EncadrantEtudiantService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
