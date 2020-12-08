import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AlunoRoutingModule } from './aluno-routing.module';
import { AlunoHomeComponent } from './aluno-home/aluno-home.component';
import { CoreModule } from 'src/app/core/core.module';
import { HeaderComponent } from 'src/app/core/header/header.component';




@NgModule({
  declarations: [ AlunoHomeComponent],
  imports: [
    CommonModule,
    AlunoRoutingModule,
    CoreModule,


  ]
})
export class AlunoModule { }
