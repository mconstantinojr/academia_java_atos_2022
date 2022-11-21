public class Coordenador extends Funcionario {
	
	private String loja;
	private Double metaLoja;
	
	//Metodos de acesso das variaveis privadas
	public String getLoja() {
		return loja;
	}
	
	public void setLoja(String loja) {
		this.loja = loja;
	}
	
	//Metodos de acesso das variaveis privadas
	public Double getMetaLoja() {
		return metaLoja;
	}
	
	public void setMetaLoja(Double metaLoja) {
		this.metaLoja = metaLoja;
	}
	
	@Override
	public Double calcularSalario(Double horaTrabalhada) {
		Double salario = 40 * horaTrabalhada * 0.07;
		return salario;
	}

}