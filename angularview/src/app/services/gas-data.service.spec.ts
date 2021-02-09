import { TestBed } from '@angular/core/testing';

import { GasDataService } from './gas-data.service';

describe('GasDataService', () => {
  let service: GasDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GasDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
