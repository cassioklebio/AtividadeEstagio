import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoodenacaomonitoriaHomeComponent } from './coodenacaomonitoria-home.component';

describe('CoodenacaomonitoriaHomeComponent', () => {
  let component: CoodenacaomonitoriaHomeComponent;
  let fixture: ComponentFixture<CoodenacaomonitoriaHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoodenacaomonitoriaHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoodenacaomonitoriaHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
