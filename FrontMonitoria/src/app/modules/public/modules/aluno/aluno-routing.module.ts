import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AlunoHomeComponent } from './aluno-home/aluno-home.component';


const routes: Routes = [
  {
    path: '',
    component: AlunoHomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlunoRoutingModule { }
