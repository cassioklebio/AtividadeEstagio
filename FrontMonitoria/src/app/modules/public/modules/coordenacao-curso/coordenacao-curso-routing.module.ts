import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CoodenacaocursoHomeComponent } from './coodenacaocurso-home/coodenacaocurso-home.component';

const routes: Routes = [
  {
    path: '',
    component: CoodenacaocursoHomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoordenacaoCursoRoutingModule { }
