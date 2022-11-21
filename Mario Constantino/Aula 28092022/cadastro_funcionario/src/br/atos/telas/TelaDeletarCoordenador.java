package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.atos.model.Coordenador;
import br.atos.repositorio.RepositorioCoordenador;
import br.atos.telas.controletelas.TelaDeletarCoordenadorControle;



public class TelaDeletarCoordenador {

	
	public void deletarCoordenador(JFrame menuCoordenadorFrame, RepositorioCoordenador repositorioCoordenador) {
		
		//Determina a quantidade de linhas da tabela
		int quantidadeDeLinhas = repositorioCoordenador.listarCoordenadores().size();
		// Determina a quantidade de colunas
		int quantidadeDeColunas = 6;
				
		String stringTextoDeletar = "Digite o cpf que deseja deletar:";
				
		// Determina a matrix os itens de linhas e colunas da tabela
				
		String [][] tabelaString = new String [quantidadeDeLinhas][quantidadeDeColunas];
				
		int posicaoLinha = 0; // Determina a posição da coluna
		int posicaoColuna = 0;// Determina a posição da linha
		
		// Percorrer todos os itens da lista 
		for(Coordenador coordenador: repositorioCoordenador.listarCoordenadores()) {
					
			//Adiciona a String Nome na celula atual de acordo com o valor das variaveis 
			//posição linha e coluna
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getNome();
			posicaoColuna++; // Incrementa a variavel coluna
					
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getCpf();
			posicaoColuna++;// Incrementa a variavel coluna
					
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getSalarioLiquido().toString();
			posicaoColuna++;// Incrementa a variavel coluna
			
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getLoja();
			posicaoColuna++;// Incrementa a variavel coluna

			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getMetaLoja().toString();
			posicaoColuna++;// Incrementa a variavel coluna
			
			tabelaString [posicaoLinha][posicaoColuna] = coordenador.getEndereco().getEndereco();
			posicaoColuna = 0;

			posicaoLinha++; // Incrementa a Varivel linha
				
		}
				
				
		// Determina os titulos das coluna da lista
		String colunasTitulos[] = {"Nome", "Cpf", "SalarioLiquido","Loja","MetaLoja","Endereco"};
				
		//Cria o frame (janela)
		JFrame frameListarCoordenador = new JFrame();
		frameListarCoordenador.setSize(500,600);
				
		//Cria o objeto do tipo tabela (interface grafica)
		JTable tabelCoordenador = new JTable(tabelaString,colunasTitulos);
		tabelCoordenador.setBounds(30,40,200,300);
				
		//Scroll
		JScrollPane scrollPaneTabela = new JScrollPane(tabelCoordenador);
		JPanel panelListarCoordenador = new JPanel();
				
		JLabel stringTextoDeletarLabel = new JLabel(stringTextoDeletar);
		panelListarCoordenador.add(stringTextoDeletarLabel);
				
		JTextField cpfTextField = new JTextField(10);
		panelListarCoordenador.add(cpfTextField);
				
		JButton botaoDeletar = new JButton("Deletar");
		panelListarCoordenador.add(botaoDeletar);
				
		JButton botaoVoltar = new JButton("Voltar");
		panelListarCoordenador.add(botaoVoltar);
				
		// Adiciona o scroll pane no painel
		panelListarCoordenador.add(scrollPaneTabela);
				
		// Adiciona o painel no frame e habilita a visibilidade do frame
		frameListarCoordenador.add(panelListarCoordenador);
		frameListarCoordenador.setVisible(true);
				
		TelaDeletarCoordenadorControle telaDeletarControle = new TelaDeletarCoordenadorControle(frameListarCoordenador, menuCoordenadorFrame, cpfTextField, repositorioCoordenador);
		botaoDeletar.addActionListener(telaDeletarControle);
		botaoVoltar.addActionListener(telaDeletarControle);
	}
	
}
