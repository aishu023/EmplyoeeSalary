import { TestBed } from '@angular/core/testing';

import { RestaurantOperationService } from './restaurant-operation.service';

describe('RestaurantOperationService', () => {
  let service: RestaurantOperationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestaurantOperationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
