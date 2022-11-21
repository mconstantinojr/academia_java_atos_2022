package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.controletelas.TelaDeletarGerenteControle;



public class TelaDeletarGerente {

	
	public void deletarGerente(JFrame menuGerenteFrame, RepositorioGerente repositorioGerente) {
		
		//Determina a quantidade de linhas da tabela
		int quantidadeDeLinhas = repositorioGerente.listarGerentes().size();
		// Determina a quantidade de colunas
		int quantidadeDeColunas = 6;
				
		String stringTextoDeletar = "Digite o cpf que deseja deletar:";
				
		// Determina a matrix os itens de linhas e colunas da tabela
				
		String [][] tabelaString = new String [quantidadeDeLinhas][quantidadeDeColunas];
				
		int posicaoLinha = 0; // Determina a posição da coluna
		int posicaoColuna = 0;// Determina a posição da linha
		
		// Percorrer todos os itens da lista 
		for(Gerente gerente: repositorioGerente.listarGerentes()) {
					
			//Adiciona a String Nome na celula atual de acordo com o valor das variaveis 
			//posição linha e coluna
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getNome();
			posicaoColuna++; // Incrementa a variavel coluna
					
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getCpf();
			posicaoColuna++;// Incrementa a variavel coluna
					
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getSalarioLiquido().toString();
			posicaoColuna++;// Incrementa a variavel coluna
			
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getRegional();
			posicaoColuna++;// Incrementa a variavel coluna

			tabelaString [posicaoLinha][posicaoColuna] = gerente.getMetaRegional().toString();
			posicaoColuna++;// Incrementa a variavel coluna
			
			tabelaString [posicaoLinha][posicaoColuna] = gerente.getEndereco().getEndereco();
			posicaoColuna = 0;

			posicaoLinha++; // Incrementa a Varivel linha
				
		}
				
				
		// Determina os titulos das coluna da lista
		String colunasTitulos[] = {"Nome", "Cpf", "SalarioLiquido","Regional","MetaRegional","Endereco"};
				
		//Cria o frame (janela)
		JFrame frameListarGerente = new JFrame();
		frameListarGerente.setSize(500,600);
				
		//Cria o objeto do tipo tabela (interface grafica)
		JTable tabelGerente = new JTable(tabelaString,colunasTitulos);
		tabelGerente.setBounds(30,40,200,300);
				
		//Scroll
		JScrollPane scrollPaneTabela = new JScrollPane(tabelGerente);
		JPanel panelListarGerente = new JPanel();
				
		JLabel stringTextoDeletarLabel = new JLabel(stringTextoDeletar);
		panelListarGerente.add(stringTextoDeletarLabel);
				
		JTextField cpfTextField = new JTextField(10);
		panelListarGerente.add(cpfTextField);
				
		JButton botaoDeletar = new JButton("Deletar");
		panelListarGerente.add(botaoDeletar);
				
		JButton botaoVoltar = new JButton("Voltar");
		panelListarGerente.add(botaoVoltar);
				
		// Adiciona o scroll pane no painel
		panelListarGerente.add(scrollPaneTabela);
				
		// Adiciona o painel no frame e habilita a visibilidade do frame
		frameListarGerente.add(panelListarGerente);
		frameListarGerente.setVisible(true);
				
		TelaDeletarGerenteControle telaDeletarControle = new TelaDeletarGerenteControle(frameListarGerente, menuGerenteFrame, cpfTextField, repositorioGerente);
		botaoDeletar.addActionListener(telaDeletarControle);
		botaoVoltar.addActionListener(telaDeletarControle);
	}
	
}
