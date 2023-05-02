import { TestBed } from '@angular/core/testing';

import { PoemSearchService } from './poem-search.service';

describe('PoemSearchService', () => {
  let service: PoemSearchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PoemSearchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
