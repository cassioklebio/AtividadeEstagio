import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PublicRoutingModule } from './public-routing.module';
import { AboutComponent } from './pages/about/about.component';
import { HomeComponent } from './pages/home/home.component';
import { FooterComponent } from 'src/app/core/footer/footer.component';
import { CoreModule } from 'src/app/core/core.module';



@NgModule({
  declarations: [AboutComponent, HomeComponent
  ],
  imports: [
    CommonModule,
    PublicRoutingModule,

  ]

})
export class PublicModule { }
