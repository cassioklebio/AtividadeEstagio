import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoordenacaoCursoRoutingModule } from './coordenacao-curso-routing.module';
import { CoodenacaocursoHomeComponent } from './coodenacaocurso-home/coodenacaocurso-home.component';


@NgModule({
  declarations: [CoodenacaocursoHomeComponent],
  imports: [
    CommonModule,
    CoordenacaoCursoRoutingModule
  ]
})
export class CoordenacaoCursoModule { }
