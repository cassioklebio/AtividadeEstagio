import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfessorRoutingModule } from './professor-routing.module';
import { ProfessorHomeComponent } from './professor-home/professor-home.component';
import { CoreModule } from 'src/app/core/core.module';


@NgModule({
  declarations: [ProfessorHomeComponent],
  imports: [
    CommonModule,
    ProfessorRoutingModule,
    CoreModule,
  ]
})
export class ProfessorModule { }
