import { TestBed } from '@angular/core/testing';

import { ContentitemService } from './contentitem.service';

describe('ContentitemService', () => {
  let service: ContentitemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContentitemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
