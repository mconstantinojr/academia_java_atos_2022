import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarProgramadorComponent } from './editar-programador.component';

describe('EditarProgramadorComponent', () => {
  let component: EditarProgramadorComponent;
  let fixture: ComponentFixture<EditarProgramadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarProgramadorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarProgramadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
