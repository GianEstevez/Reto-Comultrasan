import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PasarelaPagosPage } from './pasarela-pagos.page';

describe('PasarelaPagosPage', () => {
  let component: PasarelaPagosPage;
  let fixture: ComponentFixture<PasarelaPagosPage>;

  beforeEach(async(() => {
    fixture = TestBed.createComponent(PasarelaPagosPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
