package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.controletelas.TelaAlterarGerenteControle;

public class TelaAlterarGerente {
	public void alterarGerente(JFrame frameMenuGerente, RepositorioGerente repositorioGerente, Gerente gerenteAtual) {
		
		
		// Strings que serão usadas na Label
		String nomeTexto = "Digite o nome do gerente:";
		String cpfTexto = "Digite o CPF:";
		String salarioLiquidoTexto = "Digite o salario liquido:";
				
		String regionalTexto = "Digite a regional:";
		String metaRegionalTexto = "Digite a meta regional:";
		String enderecoTexto = "Digite o endereco:";
				
				
		// Criação do Frame (Janela)
		JFrame frameTelaAlterarGerente = new JFrame();
		frameTelaAlterarGerente.setSize(200, 300);
		frameTelaAlterarGerente.setTitle("Inserir Programador");
		frameTelaAlterarGerente.setLocation(300,300);
				
		//Criação do painel
		JPanel painelTelaAlterarGerente = new JPanel();
				
		//Criação da Labels
		JLabel nomeTextoLabel = new JLabel(nomeTexto );
		painelTelaAlterarGerente.add(nomeTextoLabel);
				
		//Criação da Caixa de texto
		JTextField nomeTextField = new JTextField(10);
		nomeTextField.setText(gerenteAtual.getNome()); // Adiciona na caixa de texto os valores do programador que será alterado
		painelTelaAlterarGerente.add(nomeTextField);
				
		JLabel cpfTextoLabel = new JLabel(cpfTexto);
		painelTelaAlterarGerente.add(cpfTextoLabel);
				
		JTextField cpfTextField = new JTextField(10);
		cpfTextField.setText(gerenteAtual.getCpf());
		painelTelaAlterarGerente.add(cpfTextField);
				
		JLabel salarioLiquidoTextoLabel = new JLabel(salarioLiquidoTexto);
		painelTelaAlterarGerente.add(salarioLiquidoTextoLabel);
				
		JTextField salarioLiquidoTextField = new JTextField(10);
		salarioLiquidoTextField.setText(gerenteAtual.getSalarioLiquido().toString());
		painelTelaAlterarGerente.add(salarioLiquidoTextField);
				
		JLabel regionalTextoLabel = new JLabel(regionalTexto);
		painelTelaAlterarGerente.add(regionalTextoLabel);
				
		JTextField regionalTextoField = new JTextField(10);
		regionalTextoField.setText(gerenteAtual.getRegional());
		painelTelaAlterarGerente.add(regionalTextoField);
				
		JLabel metaRegionalTextoLabel = new JLabel(metaRegionalTexto);
		painelTelaAlterarGerente.add(metaRegionalTextoLabel);
				
		JTextField metaRegionalTextoField = new JTextField(10);
		metaRegionalTextoField.setText(gerenteAtual.getMetaRegional().toString());
		painelTelaAlterarGerente.add(metaRegionalTextoField);
			
		JLabel enderecoTextoLabel = new JLabel(enderecoTexto);
		painelTelaAlterarGerente.add(enderecoTextoLabel);
				
		JTextField enderecoTextoField = new JTextField(10);
		enderecoTextoField.setText(gerenteAtual.getEndereco().getEndereco());
		painelTelaAlterarGerente.add(enderecoTextoField);
		
		//Criação do botão
		JButton botaoAlterar = new JButton("Alterar");
		painelTelaAlterarGerente.add(botaoAlterar);

		JButton botaoVoltar = new JButton("Voltar");
		painelTelaAlterarGerente.add(botaoVoltar);

		// Adiciona o painel "dentro" do frame(janela)
		frameTelaAlterarGerente.add(painelTelaAlterarGerente);
				
		//Habilitar visibilidade do frame(janela)
		frameTelaAlterarGerente.setVisible(true);
				
		TelaAlterarGerenteControle alterarGerenteControle = new TelaAlterarGerenteControle(frameTelaAlterarGerente, frameMenuGerente, nomeTextField, cpfTextField, salarioLiquidoTextField, regionalTextoField, metaRegionalTextoField, enderecoTextoField, repositorioGerente, gerenteAtual);
		botaoAlterar.addActionListener(alterarGerenteControle);
		botaoVoltar.addActionListener(alterarGerenteControle);
	}
}
