package br.atos.repositorio;

import java.util.List;

import br.atos.model.Coordenador;


public interface InterfaceRepositorioCoordenador {
	public boolean salvarCoordenador(Coordenador coordenador);
	public Coordenador BuscarCoordenador(String cpf);
	public List<Coordenador> listarCoordenadores();
	public boolean alterarCoordenador(Coordenador coordenadorAtual,Coordenador coordenadorNovo);
	public boolean deletarCoordenador(String cpf);
 }
