import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarProgramadorComponent } from './listar-programador.component';

describe('ListarProgramadorComponent', () => {
  let component: ListarProgramadorComponent;
  let fixture: ComponentFixture<ListarProgramadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarProgramadorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarProgramadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
