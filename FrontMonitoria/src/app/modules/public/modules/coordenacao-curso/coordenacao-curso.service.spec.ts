import { TestBed } from '@angular/core/testing';

import { CoordenacaoCursoService } from './coordenacao-curso.service';

describe('CoordenacaoCursoService', () => {
  let service: CoordenacaoCursoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CoordenacaoCursoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
