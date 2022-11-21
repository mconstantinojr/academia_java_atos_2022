package br.atos.telas;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.atos.model.Funcionario;
import br.atos.repositorio.RepositorioFuncionario;
import br.atos.telas.controletelas.TelaAlterarControle;
import br.atos.telas.controletelas.TelaExcluirControle;

public class AlterarFuncionario {

	public void apresentarLista(List<Funcionario> listaDeFuncionarios, JFrame menuInicial, RepositorioFuncionario repositorioFuncionario) {
		int quantidadeDeLinhas = listaDeFuncionarios.size();
		int quantidadeDeColunas = 4;
		
		String stringTextoIdAlterar = "Digite o id que deseja alterar:";
		
		String stringTextoNomeAlterar = "Digite o nome que deseja alterar:";
		
		String stringTextoCpfAlterar = "Digite o cpf que deseja alterar:";
		
		String stringTextoCargoAlterar = "Digite o cargo que deseja alterar:";
		
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
		panelListarFuncionario.add(scrollPaneTabela);
		
		JLabel stringTextoIdAterarLabel = new JLabel(stringTextoIdAlterar);
		panelListarFuncionario.add(stringTextoIdAterarLabel);
		
		JTextField idParaAlterarJTextField = new JTextField(10);
		panelListarFuncionario.add(idParaAlterarJTextField);
		
		JLabel stringTextoNomeAterarLabel = new JLabel(stringTextoNomeAlterar);
		panelListarFuncionario.add(stringTextoNomeAterarLabel);
		
		JTextField nomeParaAlterarJTextField = new JTextField(10);
		panelListarFuncionario.add(nomeParaAlterarJTextField);

		JLabel stringTextoCpfAterarLabel = new JLabel(stringTextoCpfAlterar);
		panelListarFuncionario.add(stringTextoCpfAterarLabel);
		
		JTextField cpfParaAlterarJTextField = new JTextField(10);
		panelListarFuncionario.add(cpfParaAlterarJTextField);

		JLabel stringTextoCargoAterarLabel = new JLabel(stringTextoCargoAlterar);
		panelListarFuncionario.add(stringTextoCargoAterarLabel);
		
		JTextField cargoParaAlterarJTextField = new JTextField(10);
		panelListarFuncionario.add(cargoParaAlterarJTextField);

		JButton botaoAlterar = new JButton("Alterar");
		panelListarFuncionario.add(botaoAlterar);
		
		frameExcluirFuncionario.add(panelListarFuncionario);
		frameExcluirFuncionario.setVisible(true);
		
		TelaAlterarControle telaExcluirControle = new TelaAlterarControle(frameExcluirFuncionario, menuInicial, idParaAlterarJTextField, nomeParaAlterarJTextField, cpfParaAlterarJTextField, cargoParaAlterarJTextField, repositorioFuncionario);
		botaoAlterar.addActionListener(telaExcluirControle);
	}
}
