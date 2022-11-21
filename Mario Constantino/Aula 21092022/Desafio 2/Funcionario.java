public class Funcionario {

	private String id;
	private String nome; // variavel privada que não pode ser acessada diretamente por outra classe
	private String cpf;
	private Double salarioLiquido;
	
	//Metodos de acesso das variaveis privadas
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Metodos de acesso das variaveis privadas
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	//Metodos de acesso das variaveis privadas
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	//Metodos de acesso das variaveis privadas
	public Double getSalarioLiquido() {
		return salarioLiquido;
	}
	
	public void setSalarioLiquido(Double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}
	
	public Double calcularSalario(Double horaTrabalhada) {
		Double salario = 50 * horaTrabalhada;
		return salario;
	}

}