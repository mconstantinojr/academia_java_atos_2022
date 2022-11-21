public class Gerente extends Funcionario {
	
	private String regional;
	private Double metaRegional;
	
	//Metodos de acesso das variaveis privadas
	public String getRegional() {
		return regional;
	}
	
	public void setRegional(String regional) {
		this.regional = regional;
	}
	
	//Metodos de acesso das variaveis privadas
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