package br.atos.repositorio;

import java.util.List;

import br.atos.model.Gerente;


public interface InterfaceRepositorioGerente {
	public boolean salvarGerente(Gerente gerente);
	public Gerente BuscarGerente(String cpf);
	public List<Gerente> listarGerentes();
	public boolean alterarGerente(Gerente gerenteAtual,Gerente gerentenovo);
	public boolean deletarGerente(String cpf);
 }
