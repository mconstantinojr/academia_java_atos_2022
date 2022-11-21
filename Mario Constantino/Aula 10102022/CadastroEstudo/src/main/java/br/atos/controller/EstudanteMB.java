package br.atos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.atos.dao.EstudanteDao;
import br.atos.model.Endereco;
import br.atos.model.Estudante;

@ManagedBean(name = "estudanteBean")
@SessionScoped
public class EstudanteMB {
	
	private List<Estudante> estudantes = new ArrayList<>();
	Estudante estudante = new Estudante();
	Estudante estudanteAlterar = null;
	EstudanteDao dao = new EstudanteDao();
	
	public EstudanteDao getDao() {
		return dao;
	}

	public void setDao(EstudanteDao dao) {
		this.dao = dao;
	}

	@PostConstruct
	public void init() {
		this.estudante = new Estudante();
		this.estudante.setEndereco(new Endereco());
		this.estudantes = dao.listarEstudante();
	}
	
	public String salvarEstudante() {
		if (estudanteAlterar != null) {
			this.estudante.setId(estudanteAlterar.getId());
			dao.alterarEstudanteNoBanco(this.estudante);
		} else {
			dao.salvarEdudanteNoBanco(this.estudante);	
		}
		
		limparEstudante();
		
		return "";
	}
	
	private void limparEstudante() {
		this.estudante = new Estudante();
		this.estudante.setEndereco(new Endereco());
		this.estudanteAlterar = null;
		this.estudantes = dao.listarEstudante();
	}
	
	public String removerEstudante(Estudante estudante) {
		dao.deleteEstudanteNoBanco(estudante);
		limparEstudante();
		
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
