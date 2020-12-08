import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { AboutComponent } from './pages/about/about.component';



const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, data: { title: 'Home', breadcrumb: [{ label: 'Home', url: '' }] } },
  { path: 'about', component: AboutComponent, data: { title: 'About', breadcrumb: [{ label: 'About', url: '' }] } },
  //  { path: 'aluno', loadChildren: () =>  AlunoModule},
  {
    path: 'aluno',
    loadChildren: () => import('./modules/aluno/aluno.module').then(m => m.AlunoModule)
  },
  {
    path: 'professor',
    loadChildren: () => import('./modules/professor/professor.module').then(m => m.ProfessorModule)
  },
  {
    path: 'secretaria',
    loadChildren: () => import('./modules/secretaria/secretaria.module').then(m => m.SecretariaModule)
  },
  {
    path: 'coodenacaoCurso',
    loadChildren: () => import('./modules/coordenacao-curso/coordenacao-curso.module').then(m => m.CoordenacaoCursoModule)
  },
  {
    path: 'coodenacaoMonitoria',
    loadChildren: () => import('./modules/coordenacao-monitoria/coordenacao-monitoria.module').then(m => m.CoordenacaoMonitoriaModule)
  }


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PublicRoutingModule {}
