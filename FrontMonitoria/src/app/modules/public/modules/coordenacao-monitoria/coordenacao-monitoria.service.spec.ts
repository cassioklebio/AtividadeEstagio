import { TestBed } from '@angular/core/testing';

import { CoordenacaoMonitoriaService } from './coordenacao-monitoria.service';

describe('CoordenacaoMonitoriaService', () => {
  let service: CoordenacaoMonitoriaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CoordenacaoMonitoriaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
