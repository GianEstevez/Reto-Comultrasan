import { ComponentFixture, TestBed } from '@angular/core/testing';
import { EnlacesPage } from './enlaces.page';

describe('EnlacesPage', () => {
  let component: EnlacesPage;
  let fixture: ComponentFixture<EnlacesPage>;

  beforeEach(async(() => {
    fixture = TestBed.createComponent(EnlacesPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
