import { catchError, Observable } from 'rxjs';
import { ModelProgramador } from './../model/model-programador';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class ServiceProgramadorService {

  constructor(private httpClient: HttpClient) {

  }

  private readonly baseUrl = "http://localhost:8080/api/";
  listarProgramador(){
    return this.httpClient.get<ModelProgramador[]>(this.baseUrl + 'programadores');
  }

  salvarProgramador(programador: ModelProgramador) : Observable<ModelProgramador>{
    return this.httpClient.post<ModelProgramador>(this.baseUrl + 'cadastrarProgramador', programador);
  }

  deletarProgramador(programdor: ModelProgramador)  {
    return this.httpClient.delete(this.baseUrl + 'programadorDelete/' +programdor.id);
  }

  buscarProgramador(id: number) {
    return this.httpClient.get<ModelProgramador>(this.baseUrl + 'programador/' +id);
  }

  atualizarProgramador(id: number, programador: ModelProgramador) : Observable<ModelProgramador>{
    programador.id = id;
    return this.httpClient.put<ModelProgramador>(this.baseUrl + 'editarProgramador', programador);
  }


}
