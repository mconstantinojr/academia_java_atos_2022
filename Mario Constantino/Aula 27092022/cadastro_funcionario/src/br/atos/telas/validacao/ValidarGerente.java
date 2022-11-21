package br.atos.telas.validacao;

import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioGerente;


public class ValidarGerente {

	public String validarGerente(Gerente gerente, RepositorioGerente repositorioGerente, String tipoValidacao) {
		
		String mensagemErro = null;
		
		if (tipoValidacao.equals("Cadastrar")) {
			if (repositorioGerente.BuscarGerente(gerente.getCpf()) != null ) {
				
				mensagemErro = "Cpf Repetido";
				return mensagemErro;
				
			}
		}
		
		if (gerente.getCpf().length() < 3 || gerente.getCpf().length() > 5) {
			
			mensagemErro = "Minimo de 3 digitos e maximo de 5 digitos para o CPF";
			return mensagemErro;
			
		}
		
		if (gerente.getNome().length() > 10 || gerente.getNome().length() < 3) {
			
			mensagemErro = "Maximo de 10 caracteres e minimo de 3 caracteres para o NOME";
			return mensagemErro;
		}

		if (gerente.getRegional().length() > 10 || gerente.getRegional().length() < 3) {
			
			mensagemErro = "Maximo de 10 caracteres e minimo de 3 caracteres para o ESTADO";
			return mensagemErro;
		}
		

		return mensagemErro;
	}

}
