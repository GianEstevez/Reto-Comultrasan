import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { PasarelaPagosPageRoutingModule } from './pasarela-pagos-routing.module';

import { PasarelaPagosPage } from './pasarela-pagos.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    PasarelaPagosPageRoutingModule
  ],
  declarations: [PasarelaPagosPage]
})
export class PasarelaPagosPageModule {}
