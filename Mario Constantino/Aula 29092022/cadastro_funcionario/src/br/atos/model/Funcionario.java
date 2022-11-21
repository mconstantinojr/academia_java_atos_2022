package br.atos.model;

public class Funcionario {
	
	private String nome;
	private String cpf;
	private Double salarioLiquido;
	private Endereco endereco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Double getSalarioLiquido() {
		return salarioLiquido;
	}
	public void setSalarioLiquido(Double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Double calcularSalario(Double horaTrabalhada) {
		Double salario = 50 * horaTrabalhada;
		return salario;
	}

}
