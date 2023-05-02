import { TestBed } from '@angular/core/testing';

import { ContentItemServiceService } from './content-item-service.service';

describe('ContentItemServiceService', () => {
  let service: ContentItemServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContentItemServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
