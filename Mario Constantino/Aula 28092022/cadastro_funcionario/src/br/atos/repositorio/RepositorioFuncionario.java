package br.atos.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.atos.model.Funcionario;

public class RepositorioFuncionario implements InterfaceRepositorioFuncionario {

	List<Funcionario> listaFuncionario = new ArrayList<>();
	
	@Override
	public boolean salvarFuncionario(Funcionario funcionario) {
		try {
			listaFuncionario.add(funcionario);
		} catch (Exception e) {
			System.out.println("Erro no cadastro de funcionario");
			return false;
		}
		
		return true;
	}

	@Override
	public List<Funcionario> listarFuncionario() {
		return listaFuncionario;
	}

	@Override
	public boolean deletarFuncionario(String id) {
		
		for(Funcionario funcionario : listaFuncionario) {
			//if (funcionario.getId().equals(id)) {
			//	listaFuncionario.remove(funcionario);
			//	return true;
			//}
		}
		
		return false;
	}

	@Override
	public boolean alterarFuncionario(Funcionario funcionarioAtual, Funcionario funcionarioParaAlterar) {
		for(Funcionario funcionario : listaFuncionario) {
			if (funcionario == funcionarioAtual) {
				listaFuncionario.remove(funcionarioAtual);
				listaFuncionario.add(funcionarioParaAlterar);
				return true;
			}
		}
		return false;
	}

	@Override
	public Funcionario buscarFuncionario(String id) {
		//for(Funcionario funcionario : listaFuncionario) {
			//if (funcionario.getId().equals(id)) {
			//	return funcionario;
			//}
		//}
		return null;
	}
	
	

}
