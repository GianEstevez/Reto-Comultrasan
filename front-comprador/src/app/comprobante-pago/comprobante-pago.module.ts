import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ComprobantePagoPageRoutingModule } from './comprobante-pago-routing.module';

import { ComprobantePagoPage } from './comprobante-pago.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ComprobantePagoPageRoutingModule
  ],
  declarations: [ComprobantePagoPage]
})
export class ComprobantePagoPageModule {}
