import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PasarelaPagosPage } from './pasarela-pagos.page';

const routes: Routes = [
  {
    path: '',
    component: PasarelaPagosPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PasarelaPagosPageRoutingModule {}
