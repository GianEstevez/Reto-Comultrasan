import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ComprobantePagoPage } from './comprobante-pago.page';

const routes: Routes = [
  {
    path: '',
    component: ComprobantePagoPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ComprobantePagoPageRoutingModule {}
