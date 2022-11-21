import { ServiceProgramadorService } from './../../service/service-programador.service';
import { ModelProgramador } from './../../model/model-programador';
import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import { Router, ActivatedRoute, ParamMap  } from '@angular/router';
import { DdMmYyyyDatePipe } from 'src/app/dd-mm-yyyy-date.pipe';

@Component({
  selector: 'app-listar-programador',
  templateUrl: './listar-programador.component.html',
  styleUrls: ['./listar-programador.component.css']
})
export class ListarProgramadorComponent implements OnInit {

  programadores: Observable<ModelProgramador[]>;
  displayedColumns = ['nome', 'salario', 'idade', 'dataNascimento', 'edit', 'delete']
  constructor(private serviceProgramadorService: ServiceProgramadorService,
    private router: Router, private actRout: ActivatedRoute) {
      this.programadores = serviceProgramadorService.listarProgramador();
  }

  ngOnInit(): void {
    this.programadores = this.serviceProgramadorService.listarProgramador();
  }

  delete(programador: ModelProgramador): void {

    this.serviceProgramadorService.deletarProgramador(programador).subscribe(
      () => {
        console.warn("Cadastro realizado com sucesso");
        this.programadores = this.serviceProgramadorService.listarProgramador();
      }
    );

  }

  edit(programador: ModelProgramador): void {
    this.router.navigate(
      ['editar',
      {programadorId: programador.id}]);
  }


}
