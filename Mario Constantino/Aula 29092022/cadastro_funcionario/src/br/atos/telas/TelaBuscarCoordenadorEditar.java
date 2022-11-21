package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.atos.model.Coordenador;
import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioCoordenador;
import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.controletelas.TelaBuscarCoordenadorController;
import br.atos.telas.controletelas.TelaBuscarGerenteController;

public class TelaBuscarCoordenadorEditar {

	public void buscarCoordenador(JFrame menuCoordenador, RepositorioCoordenador repositorioCoordenador) {
		
		//Determina a quantidade de linhas da tabela
		int quantidadeDeLinhas = repositorioCoordenador.listarCoordenadores().size();
		// Determina a quantidade de colunas
		int quantidadeDeColunas = 6;
		
		String stringTextoEditar = "Digite o cpf de quem deseja Alterar:";
		
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
		String colunasTitulos[] = {"Nome", "Cpf", "SalarioLiquido", "Regional", "MetaRegional","Endereco"};
		
		//Cria o frame (janela)
		JFrame frameListarCoordenador = new JFrame();
		frameListarCoordenador.setSize(500,600);
		
		//Cria o objeto do tipo tabela (interface grafica)
		JTable tabelaCoordenador = new JTable(tabelaString,colunasTitulos);
		tabelaCoordenador.setBounds(30,40,200,300);
		
		//Scroll
		JScrollPane scrollPaneTabela = new JScrollPane(tabelaCoordenador);
		JPanel panelListarCoordenador = new JPanel();
		
		JLabel stringTextoAlterarLabel = new JLabel(stringTextoEditar);
		panelListarCoordenador.add(stringTextoAlterarLabel);
		
		JTextField cpfTextField = new JTextField(10);
		panelListarCoordenador.add(cpfTextField);
		
		JButton botaoAlterar = new JButton("Buscar");
		panelListarCoordenador.add(botaoAlterar);

		JButton botaoVoltar = new JButton("Voltar");
		panelListarCoordenador.add(botaoVoltar);

		
		// Adiciona o scroll pane no painel
		panelListarCoordenador.add(scrollPaneTabela);
		
		// Adiciona o painel no frame e habilita a visibilidade do frame
		frameListarCoordenador.add(panelListarCoordenador);
		frameListarCoordenador.setVisible(true);
		                                                                       				  
		TelaBuscarCoordenadorController buscarCoordenadorController = new TelaBuscarCoordenadorController(frameListarCoordenador, menuCoordenador, cpfTextField, repositorioCoordenador);
		botaoAlterar.addActionListener(buscarCoordenadorController);
		botaoVoltar.addActionListener(buscarCoordenadorController);
		
		
		
		
		
	}
	
	
	
}
