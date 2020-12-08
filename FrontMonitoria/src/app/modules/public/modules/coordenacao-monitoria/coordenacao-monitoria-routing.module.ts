import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CoodenacaomonitoriaHomeComponent } from './coodenacaomonitoria-home/coodenacaomonitoria-home.component';

const routes: Routes = [
  {
    path: '',
    component: CoodenacaomonitoriaHomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoordenacaoMonitoriaRoutingModule { }
