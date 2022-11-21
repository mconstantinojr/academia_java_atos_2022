package br.atos.model;

public class Coordenador extends Funcionario {
	
	private String loja;
	private Double metaLoja;

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}
	
	@Override
	public Double calcularSalario(Double horaTrabalhada) {
		Double salario = 40 * horaTrabalhada * 0.15;
		return salario;
	}

	public Double getMetaLoja() {
		return metaLoja;
	}

	public void setMetaLoja(Double metaLoja) {
		this.metaLoja = metaLoja;
	}
}
