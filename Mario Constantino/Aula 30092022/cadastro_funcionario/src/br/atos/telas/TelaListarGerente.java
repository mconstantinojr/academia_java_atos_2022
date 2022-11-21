package br.atos.telas;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.atos.model.Funcionario;
import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.controletelas.TelaListarGerenteControle;


public class TelaListarGerente {

	public void apresentarLista(RepositorioGerente repositorioGerente, JFrame menuGerente) {
		int quantidadeDeLinhas = repositorioGerente.listarGerentes().size();
		int quantidadeDeColunas = 5;
		
		String [][] tabelaString = new String [quantidadeDeLinhas][quantidadeDeColunas];
		
		int posicaoLinha = 0;
		int posicaoColuna = 0;
		for (Gerente gerente: repositorioGerente.listarGerentes()) {
			
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getNome();
			posicaoColuna++;
			
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getCpf();
			posicaoColuna++;
			
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getSalarioLiquido().toString();
			posicaoColuna++;
			
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getRegional();
			posicaoColuna++;

			tabelaString [posicaoLinha][posicaoColuna] = gerente.getMetaRegional().toString();

			posicaoColuna = 0;
			posicaoLinha++;
		}
		
		String colunasTitulos[] = {"Nome", "Cpf", "SalarioLiquido", "Regional", "MetaRegional"};
		JFrame frameListarGerente = new JFrame();
		frameListarGerente.setSize(500, 600);
		
		JTable tabelaGerente = new JTable(tabelaString, colunasTitulos);
		tabelaGerente.setBounds(30, 40, 200, 300);
		
		JScrollPane scrollPaneTabela = new JScrollPane(tabelaGerente);
		
		JPanel panelListarGerente = new JPanel();
		panelListarGerente.add(scrollPaneTabela);
		
		frameListarGerente.add(panelListarGerente);
		frameListarGerente.setVisible(true);
		
		JButton botaoVoltar = new JButton("Voltar");
		panelListarGerente.add(botaoVoltar);
		
		TelaListarGerenteControle telaListarGerenteControle = new TelaListarGerenteControle(menuGerente, frameListarGerente);
		botaoVoltar.addActionListener(telaListarGerenteControle);
	
	}
}
