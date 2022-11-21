package br.atos.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.atos.model.Gerente;


public class RepositorioGerente implements InterfaceRepositorioGerente {

	List<Gerente> listaGerente = new ArrayList<>();

	@Override
	public boolean salvarGerente(Gerente gerente) {
		try {
			listaGerente.add(gerente);
			
			
		} catch (Exception e) {
			System.out.println("Deu erro no cadastro" + e);
			return false;
		}
		

		return true;
	}

	@Override
	public Gerente BuscarGerente(String cpf) {
		for(Gerente gerente: listaGerente) {
			if(gerente.getCpf().equals(cpf)) {
				return gerente;
				
			}
			
		}
		
		return null;
	}

	@Override
	public List<Gerente> listarGerentes() {
		// TODO Auto-generated method stub
		return listaGerente;
	}

	@Override
	public boolean alterarGerente(Gerente gerenteAtual, Gerente gerentenovo) {
		for(Gerente gerente: listaGerente) {
			if(gerente == gerenteAtual) {
				listaGerente.remove(gerenteAtual);
				listaGerente.add(gerentenovo);
				return true;
				
			}

		}
		
		return false;
	}

	@Override
	public boolean deletarGerente(String cpf) {
		for (Gerente gerente : listaGerente) {
			//Verificar se vai funcionar
			if(gerente.getCpf().equals(cpf)) {
				
				listaGerente.remove(gerente);
				return true;
			}
			
		}
		
		return false;
	}
	
	

}
