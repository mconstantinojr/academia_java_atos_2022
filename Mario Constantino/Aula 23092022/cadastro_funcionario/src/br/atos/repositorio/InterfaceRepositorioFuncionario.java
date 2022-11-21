package br.atos.repositorio;

import java.util.List;

import br.atos.model.Funcionario;

public interface InterfaceRepositorioFuncionario {
	public boolean salvarFuncionario(Funcionario funcionario);
	public List<Funcionario> listarFuncionario();
	public boolean deletarFuncionario(String id);
	public boolean alterarFuncionario(Funcionario funcionarioParaAlterar);
 }
