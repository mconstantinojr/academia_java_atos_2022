package br.atos.telas.validacao;

import br.atos.model.Coordenador;
import br.atos.repositorio.RepositorioCoordenador;


public class ValidarCoordenador {

	public String validarCoordenador(Coordenador coordenador, RepositorioCoordenador repositorioCoordenador, String tipoValidacao) {
		
		String mensagemErro = null;
		
		if (tipoValidacao.equals("Cadastrar")) {
			if (repositorioCoordenador.BuscarCoordenador(coordenador.getCpf()) != null ) {
				
				mensagemErro = "Cpf Repetido";
				return mensagemErro;
				
			}
		}
		
		if (coordenador.getCpf().length() < 3 || coordenador.getCpf().length() > 5) {
			
			mensagemErro = "Minimo de 3 digitos e maximo de 5 digitos para o CPF";
			return mensagemErro;
			
		}
		
		if (coordenador.getNome().length() > 10 || coordenador.getNome().length() < 3) {
			
			mensagemErro = "Maximo de 10 caracteres e minimo de 3 caracteres para o NOME";
			return mensagemErro;
		}

		if (coordenador.getLoja().length() > 10 || coordenador.getLoja().length() < 3) {
			
			mensagemErro = "Maximo de 10 caracteres e minimo de 3 caracteres para o ESTADO";
			return mensagemErro;
		}
		

		return mensagemErro;
	}

}
