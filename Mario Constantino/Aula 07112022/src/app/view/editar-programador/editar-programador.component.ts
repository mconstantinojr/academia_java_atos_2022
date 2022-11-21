import { ServiceProgramadorService } from './../../service/service-programador.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap, Params } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-editar-programador',
  templateUrl: './editar-programador.component.html',
  styleUrls: ['./editar-programador.component.css']
})
export class EditarProgramadorComponent implements OnInit {
  programadorId: number = 0;
  formEditar: FormGroup = new FormGroup({});

  constructor(private formBuilder: FormBuilder, private router: Router,
    private activateRoute: ActivatedRoute,
    public programadorService: ServiceProgramadorService) { }





  ngOnInit(): void {
    this.activateRoute.params.subscribe((params : Params) => {
      this.programadorId = +params['programadorId'];
    })
    if (this.programadorId) {
      this.formEditar = this.formBuilder.group({
        nome:  ['', [Validators.required]],
        idade:  ['', [Validators.required]],
        salario:  [ '', [Validators.required]],
        dataNascimento: [ '', [Validators.required]]
      });

      this.programadorService.buscarProgramador(this.programadorId).subscribe(prog => this.formEditar.patchValue(prog));

    }
  }

  salvarProgramador() {
     this.programadorService.atualizarProgramador(this.programadorId, this.formEditar.value).subscribe(() => {
        this.router.navigate([''])
      })
  }

  voltar() {
    this.router.navigate([''])
  }
}
