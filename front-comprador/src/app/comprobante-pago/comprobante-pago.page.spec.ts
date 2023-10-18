import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ComprobantePagoPage } from './comprobante-pago.page';

describe('ComprobantePagoPage', () => {
  let component: ComprobantePagoPage;
  let fixture: ComponentFixture<ComprobantePagoPage>;

  beforeEach(async(() => {
    fixture = TestBed.createComponent(ComprobantePagoPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
