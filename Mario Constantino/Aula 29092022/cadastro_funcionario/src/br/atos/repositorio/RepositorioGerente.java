package br.atos.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.atos.model.Gerente;
import br.atos.persistencia.GerenteDao;


public class RepositorioGerente implements InterfaceRepositorioGerente {

	List<Gerente> listaGerente = new ArrayList<>();
	GerenteDao gerenteDao = new GerenteDao();

	@Override
	public boolean salvarGerente(Gerente gerente) {
		try {
			gerenteDao.salvarGerenteNoBanco(gerente);
			
		} catch (Exception e) {
			System.out.println("Deu erro no cadastro" + e);
			return false;
		}
		

		return true;
	}

	@Override
	public Gerente BuscarGerente(String cpf) {
		for(Gerente gerente: gerenteDao.listarGerente()) {
			if(gerente.getCpf().equals(cpf)) {
				return gerente;
				
			}
			
		}
		
		return null;
	}

	@Override
	public List<Gerente> listarGerentes() {
		// TODO Auto-generated method stub
		return gerenteDao.listarGerente();
	}

	@Override
	public boolean alterarGerente(Gerente gerenteAtual, Gerente gerentenovo) {
		try {
			gerenteDao.alterarGerenteNoBanco(gerentenovo);
			
		} catch (Exception e) {
			System.out.println("Deu erro no alterar" + e);
			return false;
		}
		

		return true;
	}

	@Override
	public boolean deletarGerente(String cpf) {
		try {
			gerenteDao.deleteGerenteNoBanco(cpf);
			
		} catch (Exception e) {
			System.out.println("Deu erro no delete" + e);
			return false;
		}
		

		return true;
	}
	
	

}
