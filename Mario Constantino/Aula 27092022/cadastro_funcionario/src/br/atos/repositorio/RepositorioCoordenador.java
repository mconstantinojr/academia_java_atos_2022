package br.atos.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.atos.model.Coordenador;


public class RepositorioCoordenador implements InterfaceRepositorioCoordenador {

	List<Coordenador> listaCoordenadores = new ArrayList<>();


	@Override
	public boolean salvarCoordenador(Coordenador coordenador) {
		try {
			listaCoordenadores.add(coordenador);
			
			
		} catch (Exception e) {
			System.out.println("Deu erro no cadastro" + e);
			return false;
		}
		

		return true;
	}

	@Override
	public Coordenador BuscarCoordenador(String cpf) {
		for(Coordenador coordenador: listaCoordenadores) {
			if(coordenador.getCpf().equals(cpf)) {
				return coordenador;
				
			}
			
		}
		
		return null;
	}

	@Override
	public List<Coordenador> listarCoordenadores() {
		// TODO Auto-generated method stub
		return listaCoordenadores;
	}

	@Override
	public boolean alterarCoordenador(Coordenador coordenadorAtual, Coordenador coordenadorNovo) {
		for(Coordenador coordenador: listaCoordenadores) {
			if(coordenador == coordenadorAtual) {
				listaCoordenadores.remove(coordenadorAtual);
				listaCoordenadores.add(coordenadorNovo);
				return true;
				
			}

		}
		
		return false;
	}

	@Override
	public boolean deletarCoordenador(String cpf) {
		for (Coordenador coordenador : listaCoordenadores) {
			//Verificar se vai funcionar
			if(coordenador.getCpf().equals(cpf)) {
				
				listaCoordenadores.remove(coordenador);
				return true;
			}
			
		}
		
		return false;
	}
	
	

}
