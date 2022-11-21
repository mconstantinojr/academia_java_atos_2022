import { EditarProgramadorComponent } from './view/editar-programador/editar-programador.component';
import { CadastrarProgramadorComponent } from './view/cadastrar-programador/cadastrar-programador.component';
import { HomeComponent } from './view/home/home.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: HomeComponent, title: 'Inicio'},
  { path: 'adicionar', component: CadastrarProgramadorComponent, title: 'Adicionar'},
  { path: 'editar', component: EditarProgramadorComponent, title: 'Editar'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
