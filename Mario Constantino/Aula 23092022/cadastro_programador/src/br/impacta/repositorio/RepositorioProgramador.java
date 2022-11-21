package br.impacta.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.impacta.model.Programador;

public class RepositorioProgramador implements InterfaceRepositorioProgramador {

	List<Programador> listaProgramadores = new ArrayList<>();
	
	@Override
	public boolean salvarProgramdor(Programador programador) {
		
		try {
			listaProgramadores.add(programador);
		} catch (Exception e) {
			System.out.println("Erro no cadastro de programador");
			return false;
		}
		
		return true;
	}

	@Override
	public List<Programador> listarProgramador() {
		return listaProgramadores;
	}

	@Override
	public boolean deletarProgramador(String cpf) {
		for (Programador programador : listaProgramadores) {
			if (programador.getCpf().equals(cpf)) {
				listaProgramadores.remove(programador);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean alterarProgramador(Programador programadorParaAlterar) {
		for (Programador programador : listaProgramadores) {
			if (programador.getCpf().equals(programadorParaAlterar.getCpf())) {
				listaProgramadores.remove(programador);
				listaProgramadores.add(programadorParaAlterar);
				return true;
			}
		}
		return false;
	}
	
	

}
