import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoordenacaoMonitoriaRoutingModule } from './coordenacao-monitoria-routing.module';
import { CoodenacaomonitoriaHomeComponent } from './coodenacaomonitoria-home/coodenacaomonitoria-home.component';


@NgModule({
  declarations: [CoodenacaomonitoriaHomeComponent],
  imports: [
    CommonModule,
    CoordenacaoMonitoriaRoutingModule
  ]
})
export class CoordenacaoMonitoriaModule { }
