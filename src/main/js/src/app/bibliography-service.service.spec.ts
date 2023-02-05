import { TestBed } from '@angular/core/testing';

import { BibliographyServiceService } from './bibliography-service.service';

describe('BibliographyServiceService', () => {
  let service: BibliographyServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BibliographyServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
