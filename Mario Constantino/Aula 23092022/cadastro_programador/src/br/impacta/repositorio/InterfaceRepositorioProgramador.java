package br.impacta.repositorio;

import java.util.List;

import br.impacta.model.Programador;

public interface InterfaceRepositorioProgramador {
	public boolean salvarProgramdor(Programador programador);
	public List<Programador> listarProgramador();
	public boolean deletarProgramador(String cpf);
	public boolean alterarProgramador(Programador programadorParaAlterar);
 }
