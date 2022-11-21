package br.atos.cadastro_animais_zoo.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CUIDADOR")
@SequenceGenerator(name = "sequence", sequenceName = "sequenciaIdConsumidor")
public class Cuidador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenciaIdConsumidor")
	private long idCuidador;
	
	private String matricula;
	private String nome;
	
	public void atribuirMatricula(Integer idCuidador) {
		this.matricula = "Z000" + idCuidador;
	}
	
	public long getIdCuidador() {
		return idCuidador;
	}
	public void setIdCuidador(long idCuidador) {
		this.idCuidador = idCuidador;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
