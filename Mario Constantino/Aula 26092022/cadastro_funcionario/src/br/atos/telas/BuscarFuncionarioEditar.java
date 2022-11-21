package br.atos.telas;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.atos.model.Funcionario;
import br.atos.repositorio.RepositorioFuncionario;
import br.atos.telas.controletelas.BuscarFuncionarioController;

public class BuscarFuncionarioEditar {

	public void buscarFuncionarioEditar(RepositorioFuncionario repositorioFuncionario, JFrame menuInicial) {

		int quantidadeDeLinhas = repositorioFuncionario.listarFuncionario().size();
		int quantidadeDeColunas = 4;
		
		String [][] tabelaString = new String [quantidadeDeLinhas][quantidadeDeColunas];
		
		int posicaoLinha = 0;
		int posicaoColuna = 0;
		for (Funcionario funcionario: repositorioFuncionario.listarFuncionario()) {
			
			tabelaString [posicaoLinha][posicaoColuna] = funcionario.getId();
			posicaoColuna++;
			
			tabelaString [posicaoLinha][posicaoColuna] = funcionario.getNome();
			posicaoColuna++;
			
			tabelaString [posicaoLinha][posicaoColuna] = funcionario.getCpf();
			posicaoColuna++;
			
			tabelaString [posicaoLinha][posicaoColuna] = funcionario.getCargo();
			posicaoColuna = 0;
			posicaoLinha++;
		}
		
		String colunasTitulos[] = {"Id", "Nome", "Cpf", "Cargo"};
		JFrame frameListarFuncionario = new JFrame();
		frameListarFuncionario.setSize(500, 600);
		
		JTable tabelaFuncionario = new JTable(tabelaString, colunasTitulos);
		tabelaFuncionario.setBounds(30, 40, 200, 300);
		
		JScrollPane scrollPaneTabela = new JScrollPane(tabelaFuncionario);
		
		JPanel panelListarFuncionario = new JPanel();
		
		JTextField idTextField = new JTextField(10);
		panelListarFuncionario.add(idTextField);
		
		JButton botaoAlterar = new JButton("Alterar");
		panelListarFuncionario.add(botaoAlterar);

		JButton botaoVoltar = new JButton("Voltar");
		panelListarFuncionario.add(botaoVoltar);

		panelListarFuncionario.add(scrollPaneTabela);
		
		frameListarFuncionario.add(panelListarFuncionario);
		frameListarFuncionario.setVisible(true);
		
		BuscarFuncionarioController buscarFuncionarioController = new BuscarFuncionarioController(frameListarFuncionario, menuInicial, idTextField, repositorioFuncionario );
		botaoAlterar.addActionListener(buscarFuncionarioController);
		botaoVoltar.addActionListener(buscarFuncionarioController);
		
	}
}
