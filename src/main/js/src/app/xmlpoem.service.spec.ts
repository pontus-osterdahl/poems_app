import { TestBed } from '@angular/core/testing';

import { XmlpoemService } from './xmlpoem.service';

describe('XmlpoemService', () => {
  let service: XmlpoemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(XmlpoemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
