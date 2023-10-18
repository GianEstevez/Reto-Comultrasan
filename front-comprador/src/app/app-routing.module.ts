import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./pasarela-pagos/pasarela-pagos.module').then( m => m.PasarelaPagosPageModule)
    //import('./home/home.module').then( m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'pasarela-pagos',
    loadChildren: () => import('./pasarela-pagos/pasarela-pagos.module').then( m => m.PasarelaPagosPageModule)
  },  {
    path: 'transaccion',
    loadChildren: () => import('./transaccion/transaccion.module').then( m => m.TransaccionPageModule)
  },
  {
    path: 'comprobante-pago',
    loadChildren: () => import('./comprobante-pago/comprobante-pago.module').then( m => m.ComprobantePagoPageModule)
  },


];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
