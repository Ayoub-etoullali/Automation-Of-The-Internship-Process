import { TestBed } from '@angular/core/testing';

import { LivrableService } from './livrable.service';

describe('LivrableService', () => {
  let service: LivrableService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LivrableService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
