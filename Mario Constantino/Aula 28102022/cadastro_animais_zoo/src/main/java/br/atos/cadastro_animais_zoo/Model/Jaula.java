package br.atos.cadastro_animais_zoo.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_JAULA")
public class Jaula implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idJaula;
	
	private String nomeZoologico;
	private String bloco;
	private Integer numJaula;
	
	@ManyToMany
	@JoinTable(name = "TB_jaula_cuidadores",
		joinColumns = @JoinColumn(name = "id_jaula"),
		inverseJoinColumns = @JoinColumn(name = "id_cuidador"))
	private List<Cuidador> cuidadores;

	public long getIdJaula() {
		return idJaula;
	}

	public void setIdJaula(long idJaula) {
		this.idJaula = idJaula;
	}

	public String getNomeZoologico() {
		return nomeZoologico;
	}

	public void setNomeZoologico(String nomeZoologico) {
		this.nomeZoologico = nomeZoologico;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public Integer getNumJaula() {
		return numJaula;
	}

	public void setNumJaula(Integer numJaula) {
		this.numJaula = numJaula;
	}

	public List<Cuidador> getCuidadores() {
		return cuidadores;
	}

	public void setCuidadores(List<Cuidador> cuidadores) {
		this.cuidadores = cuidadores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
