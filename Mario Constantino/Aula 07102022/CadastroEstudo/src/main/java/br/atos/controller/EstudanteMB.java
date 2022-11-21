package br.atos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.atos.model.Endereco;
import br.atos.model.Estudante;

@ManagedBean(name = "estudanteBean")
@SessionScoped
public class EstudanteMB {
	
	private List<Estudante> estudantes = new ArrayList<>();
	Estudante estudante = new Estudante();
	Estudante estudanteAlterar = null;
	
	@PostConstruct
	public void init() {
		this.estudante = new Estudante();
		this.estudante.setEndereco(new Endereco());
	}
	
	public String salvarEstudante() {
		if (estudanteAlterar != null) {
			estudantes.remove(estudanteAlterar);
		}
		estudantes.add(this.estudante);
		limparEstudante();
		
		return "";
	}
	
	private void limparEstudante() {
		this.estudante = new Estudante();
		this.estudante.setEndereco(new Endereco());
		this.estudanteAlterar = null;
	}
	
	public String removerEstudante(Estudante estudante) {
		estudantes.remove(estudante);
		
		return "";
	}
	
	public String editarEstudante(Estudante estudante) {
		this.estudante.setNome(estudante.getNome());
		this.estudante.setCpf(estudante.getCpf());
		this.estudante.getEndereco().setRua(estudante.getEndereco().getRua());
		this.estudante.getEndereco().setCidade(estudante.getEndereco().getCidade());
		this.estudante.getEndereco().setCasa(estudante.getEndereco().getCasa());
		this.estudante.setTurma(estudante.getTurma());
		this.estudante.setMedia(estudante.getMedia());
		estudanteAlterar = estudante;
		
		return "";
	}
	public List<Estudante> getEstudantes() {
		return estudantes;
	}
	public void setEstudantes(List<Estudante> estudantes) {
		this.estudantes = estudantes;
	}
	public Estudante getEstudante() {
		return estudante;
	}
	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	public Estudante getEstudanteAlterar() {
		return estudanteAlterar;
	}
	public void setEstudanteAlterar(Estudante estudanteAlterar) {
		this.estudanteAlterar = estudanteAlterar;
	}
	
	

}
