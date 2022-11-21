import { ServiceProgramadorService } from './../../service/service-programador.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators, FormArray } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap, Params } from '@angular/router';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-cadastrar-programador',
  templateUrl: './cadastrar-programador.component.html',
  styleUrls: ['./cadastrar-programador.component.css']
})
export class CadastrarProgramadorComponent implements OnInit {
  formCadastro: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router,
    private activateRoute: ActivatedRoute,
    public programadorService: ServiceProgramadorService) {
      this.formCadastro = new FormGroup({
        nome:  new FormControl('', [Validators.required]),
        idade:  new FormControl('', [Validators.required]),
        dataNascimento:  new FormControl('', [Validators.required]),
        salario:  new FormControl('', [Validators.required])
      });

  }

  setRequired() {
		return [Validators.required];
	}

  ngOnInit(): void {
          this.formCadastro = this.formBuilder.group({
            nome:  ['', [Validators.required]],
            idade:  ['', [Validators.required, Validators.min(0), Validators.max(200)]],
            dataNascimento:  ['', [Validators.required]],
            salario:  ['', [Validators.required, Validators.min(0), Validators.max(200000)]]
     })
  }

  salvarProgramador() {
    if (this.formCadastro.valid) {
        this.programadorService.salvarProgramador(this.formCadastro.value).subscribe(() => {
          console.warn("Cadastro realizado com sucesso");
          this.router.navigate([''])
      })
    }

  }

  voltar() {
    this.router.navigate([''])
  }
}
