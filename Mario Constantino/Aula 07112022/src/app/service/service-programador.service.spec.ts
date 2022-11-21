import { TestBed } from '@angular/core/testing';

import { ServiceProgramadorService } from './service-programador.service';

describe('ServiceProgramadorService', () => {
  let service: ServiceProgramadorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceProgramadorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
