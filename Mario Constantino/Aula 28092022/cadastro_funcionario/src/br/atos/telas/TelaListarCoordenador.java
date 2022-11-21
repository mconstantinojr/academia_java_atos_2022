package br.atos.telas;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.atos.model.Coordenador;
import br.atos.model.Funcionario;
import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioCoordenador;
import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.controletelas.TelaListarCoordenadorControle;
import br.atos.telas.controletelas.TelaListarGerenteControle;


public class TelaListarCoordenador {

	public void apresentarLista(RepositorioCoordenador repositorioCoordenador, JFrame menuCoordenador) {
		int quantidadeDeLinhas = repositorioCoordenador.listarCoordenadores().size();
		int quantidadeDeColunas = 6;
		
		String [][] tabelaString = new String [quantidadeDeLinhas][quantidadeDeColunas];
		
		int posicaoLinha = 0;
		int posicaoColuna = 0;
		for (Coordenador coordenador: repositorioCoordenador.listarCoordenadores()) {
			
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getNome();
			posicaoColuna++;
			
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getCpf();
			posicaoColuna++;
			
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getSalarioLiquido().toString();
			posicaoColuna++;
			
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getLoja();
			posicaoColuna++;

			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getMetaLoja().toString();
			posicaoColuna++;
			
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getEndereco().getEndereco();
			
			
			posicaoColuna = 0;
			posicaoLinha++;
		}
		
		String colunasTitulos[] = {"Nome", "Cpf", "SalarioLiquido", "Regional", "MetaRegional","Endereco"};
		JFrame frameListarCoordenador = new JFrame();
		frameListarCoordenador.setSize(500, 600);
		
		JTable tabelaCoordenador = new JTable(tabelaString, colunasTitulos);
		tabelaCoordenador.setBounds(30, 40, 200, 300);
		
		JScrollPane scrollPaneTabela = new JScrollPane(tabelaCoordenador);
		
		JPanel panelListarCoordenador = new JPanel();
		panelListarCoordenador.add(scrollPaneTabela);
		
		frameListarCoordenador.add(panelListarCoordenador);
		frameListarCoordenador.setVisible(true);
		
		JButton botaoVoltar = new JButton("Voltar");
		panelListarCoordenador.add(botaoVoltar);
		
		TelaListarCoordenadorControle telaListarCoordenadorControle = new TelaListarCoordenadorControle(menuCoordenador, frameListarCoordenador);
		botaoVoltar.addActionListener(telaListarCoordenadorControle);
	
	}
}
