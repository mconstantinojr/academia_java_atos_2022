package br.atos.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.atos.model.Funcionario;

public class RepositorioFuncionario implements InterfaceRepositorioFuncionario {

	List<Funcionario> listaFuncionario = new ArrayList<>();
	
	@Override
	public boolean salvarFuncionario(Funcionario funcionario) {
		int idContador;
		idContador = listaFuncionario.size() + 1;
		String id = Integer.toString(idContador);
		funcionario.setId(id);
		
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
		boolean resposta = false;
		
		Funcionario funcionarioRemover = new Funcionario();
		for(Funcionario funcionario : listaFuncionario) {
			if (funcionario.getId().equals(id)) {
				funcionarioRemover = funcionario;
			}
		}
		
		try {
			listaFuncionario.remove(funcionarioRemover);
			resposta = true;
		} catch (Exception e) {
			System.out.println("Erro na exclusao de funcionario");
		}
		
		return resposta;
	}
	
	

}
