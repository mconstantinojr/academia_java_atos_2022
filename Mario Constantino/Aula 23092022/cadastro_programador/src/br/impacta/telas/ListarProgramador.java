package br.impacta.telas;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.impacta.model.Programador;

public class ListarProgramador {

	public void apresentarLista(List<Programador> listaDeProgramadores, JFrame menuInicial) {
		int quantidadeDeLinhas = listaDeProgramadores.size();
		
		String [][] tabelaString = new String [quantidadeDeLinhas][3];
		
		int posicaoLinha = 0;
		int posicaoColuna = 0;
		for (Programador programador: listaDeProgramadores) {
			
			tabelaString [posicaoLinha][posicaoColuna] = programador.getNome();
			posicaoColuna++;
			
			tabelaString [posicaoLinha][posicaoColuna] = programador.getCpf();
			posicaoColuna++;
			
			tabelaString [posicaoLinha][posicaoColuna] = programador.getEstado();
			posicaoColuna = 0;
			posicaoLinha++;
		}
		
		String colunasTitulos[] = {"Nome", "Cpf", "Estado"};
		JFrame frameListarProgramador = new JFrame();
		frameListarProgramador.setSize(500, 600);
		
		JTable tabelaProgramador = new JTable(tabelaString, colunasTitulos);
		tabelaProgramador.setBounds(30, 40, 200, 300);
		
		JScrollPane scrollPaneTabela = new JScrollPane(tabelaProgramador);
		
		JPanel panelListarProgramador = new JPanel();
		panelListarProgramador.add(scrollPaneTabela);
		
		frameListarProgramador.add(panelListarProgramador);
		frameListarProgramador.setVisible(true);
		
	}
}
