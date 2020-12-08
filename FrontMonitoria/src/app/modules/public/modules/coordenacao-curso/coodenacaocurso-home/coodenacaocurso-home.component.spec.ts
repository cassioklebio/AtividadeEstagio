import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoodenacaocursoHomeComponent } from './coodenacaocurso-home.component';

describe('CoodenacaocursoHomeComponent', () => {
  let component: CoodenacaocursoHomeComponent;
  let fixture: ComponentFixture<CoodenacaocursoHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoodenacaocursoHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoodenacaocursoHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
