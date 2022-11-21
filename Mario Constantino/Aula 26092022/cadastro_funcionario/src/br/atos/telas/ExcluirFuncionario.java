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
import br.atos.telas.controletelas.TelaExcluirControle;

public class ExcluirFuncionario {

	public void apresentarLista(List<Funcionario> listaDeFuncionarios, JFrame menuInicial, RepositorioFuncionario repositorioFuncionario) {
		int quantidadeDeLinhas = listaDeFuncionarios.size();
		int quantidadeDeColunas = 4;
		
		String [][] tabelaString = new String [quantidadeDeLinhas][quantidadeDeColunas];
		
		int posicaoLinha = 0;
		int posicaoColuna = 0;
		for (Funcionario funcionario: listaDeFuncionarios) {
			
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
		JFrame frameExcluirFuncionario = new JFrame();
		frameExcluirFuncionario.setSize(500, 600);
		
		JTable tabelaFuncionario = new JTable(tabelaString, colunasTitulos);
		tabelaFuncionario.setBounds(30, 40, 200, 300);
		
		JPanel panelListarFuncionario = new JPanel();
		JScrollPane scrollPaneTabela = new JScrollPane(tabelaFuncionario);
		
		
		JTextField idParaExcluirJTextField = new JTextField(10);
		panelListarFuncionario.add(idParaExcluirJTextField);
		
		JButton botaoExcluir = new JButton("Excluir");
		panelListarFuncionario.add(botaoExcluir);
		
		JButton botaoVoltar = new JButton("Voltar");
		panelListarFuncionario.add(botaoVoltar);
		
		panelListarFuncionario.add(scrollPaneTabela);
		
		frameExcluirFuncionario.add(panelListarFuncionario);
		frameExcluirFuncionario.setVisible(true);
		
		TelaExcluirControle telaExcluirControle = new TelaExcluirControle(frameExcluirFuncionario, menuInicial, idParaExcluirJTextField, repositorioFuncionario);
		botaoExcluir.addActionListener(telaExcluirControle);
		botaoVoltar.addActionListener(telaExcluirControle);
	}
}
