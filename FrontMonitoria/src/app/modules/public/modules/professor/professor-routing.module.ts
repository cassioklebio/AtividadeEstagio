import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfessorHomeComponent } from './professor-home/professor-home.component';

const routes: Routes = [
  {
    path: '',
    component: ProfessorHomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfessorRoutingModule { }
