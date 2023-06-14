import { TestBed } from '@angular/core/testing';

import { PosteService } from './poste.service';

describe('PosteService', () => {
  let service: PosteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PosteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
