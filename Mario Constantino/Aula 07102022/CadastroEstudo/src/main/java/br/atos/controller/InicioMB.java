package br.atos.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "inicio")
public class InicioMB {

	public String cadastrarProfessor() {
		return "crudprofessor.xhtml";
	}
	
	public String cadastrarAluno() {
		return "crudestudante.xhtml";
	}

}
