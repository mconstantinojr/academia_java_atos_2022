package br.atos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.atos.model.Endereco;
import br.atos.model.Professor;

@ManagedBean(name = "professorBean")
@SessionScoped
public class ProfessorMB {
	
	@PostConstruct
	public void init() {
	    this.professor = new Professor();
	    this.professor.setEndereco(new Endereco());
	}
	
	private List<Professor> professores = new ArrayList<>();
	Professor professor = new Professor();
	Professor professorAlterar = null;
	
	
	public Professor getProfessorAlterar() {
		return professorAlterar;
	}

	public void setProfessorAlterar(Professor professorAlterar) {
		this.professorAlterar = professorAlterar;
	}

	public String salvarProfessor() {
		if (professorAlterar != null) {
			professores.remove(professorAlterar);
		}
		professores.add(professor);
		limparProfessor();
		
		return "";
	}
	
	public String editarProfessor(Professor professor) {
		this.professor.setNome(professor.getNome());
		this.professor.setCpf(professor.getCpf());
		this.professor.getEndereco().setRua(professor.getEndereco().getRua());
		this.professor.getEndereco().setCidade(professor.getEndereco().getCidade());
		this.professor.getEndereco().setCasa(professor.getEndereco().getCasa());
		this.professor.setDisciplina(professor.getDisciplina());
		this.professor.setSalario(professor.getSalario());
		professorAlterar = professor;
		
		return "";
	}

	public String removerProfessor(Professor professor) {
		professores.remove(professor);
		return "";
	}
	
	private void limparProfessor() {
		this.professor = new Professor();
		this.professor.setEndereco(new Endereco());
		this.professorAlterar = null;
		
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;

	}


}
