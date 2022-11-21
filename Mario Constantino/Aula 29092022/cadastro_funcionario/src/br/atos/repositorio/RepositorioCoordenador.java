package br.atos.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.atos.model.Coordenador;
import br.atos.persistencia.CoordenadorDao;


public class RepositorioCoordenador implements InterfaceRepositorioCoordenador {

	List<Coordenador> listaCoordenadores = new ArrayList<>();
	CoordenadorDao dao = new CoordenadorDao();


	@Override
	public boolean salvarCoordenador(Coordenador coordenador) {
		try {
			dao.salvarCoordenadorNoBanco(coordenador);
			
			
		} catch (Exception e) {
			System.out.println("Deu erro no cadastro" + e);
			return false;
		}
		

		return true;
	}

	@Override
	public Coordenador BuscarCoordenador(String cpf) {
		for(Coordenador coordenador: dao.listarCoordenador()) {
			if(coordenador.getCpf().equals(cpf)) {
				return coordenador;
				
			}
			
		}
		
		return null;
	}

	@Override
	public List<Coordenador> listarCoordenadores() {
		// TODO Auto-generated method stub
		return dao.listarCoordenador();
	}

	@Override
	public boolean alterarCoordenador(Coordenador coordenadorAtual, Coordenador coordenadorNovo) {
		try {
			dao.alterarCoordenadorNoBanco(coordenadorNovo);
			
			
		} catch (Exception e) {
			System.out.println("Deu erro no alteracao" + e);
			return false;
		}
		

		return true;
	}

	@Override
	public boolean deletarCoordenador(String cpf) {
		try {
			dao.deleteCoordenadorNoBanco(cpf);
			
			
		} catch (Exception e) {
			System.out.println("Deu erro no delete" + e);
			return false;
		}
		

		return true;
	}
	
	

}
