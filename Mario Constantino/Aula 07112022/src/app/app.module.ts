import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatTableModule} from '@angular/material/table';
import {HttpClientModule} from '@angular/common/http';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HomeComponent} from './view/home/home.component';
import {ListarProgramadorComponent} from './view/listar-programador/listar-programador.component';
import {CadastrarProgramadorComponent } from './view/cadastrar-programador/cadastrar-programador.component';
import { EditarProgramadorComponent } from './view/editar-programador/editar-programador.component';
import { DdMmYyyyDatePipe } from './dd-mm-yyyy-date.pipe';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ListarProgramadorComponent,
    CadastrarProgramadorComponent,
    EditarProgramadorComponent,
    DdMmYyyyDatePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatTableModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatFormFieldModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
