package br.atos.model;

public class Gerente extends Funcionario {
	
	public String regional;
	private Double metaRegional;

	public String getRegional() {
		return regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

	public Double getMetaRegional() {
		return metaRegional;
	}

	public void setMetaRegional(Double metaRegional) {
		this.metaRegional = metaRegional;
	}
	
	@Override
	public Double calcularSalario(Double horaTrabalhada) {
		Double salario = 60 * horaTrabalhada * 0.15;
		return salario;
	}
	
}
