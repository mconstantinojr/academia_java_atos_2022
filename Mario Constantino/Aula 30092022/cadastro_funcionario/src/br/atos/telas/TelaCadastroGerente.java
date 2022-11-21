package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.controletelas.TelaCadastroGerenteControle;

public class TelaCadastroGerente {

	public void registrarGerente(JTextField opcaoMenuJText, JFrame frameMenuGerente, RepositorioGerente repositorioGerente) {
		
		String nomeTexto = "Digite o nome do Gerente:";
		String cpfTexto = "Digite o CPF:";
		String salarioLiquidoTexto = "Digite o Salario Liquido:";
		String regionalTexto = "Digite a regional:";
		String metaRegionalTexto = "Digite a meta regional:";
		String enderecoTexto = "Digite o endereco:";
		
		JFrame frameTelaCadastroGerente = new JFrame();
		frameTelaCadastroGerente.setSize(200,300);
		frameTelaCadastroGerente.setTitle("Inserir Gerente");
		frameTelaCadastroGerente.setLocation(300,300);
		
		JPanel painelTelaCadastroGerente = new JPanel();
		
		JLabel nomeTextoLabel = new JLabel(nomeTexto);
		painelTelaCadastroGerente.add(nomeTextoLabel);
		
		JTextField nomeTextField = new JTextField(10);
		painelTelaCadastroGerente.add(nomeTextField);
		
		JLabel cpfTextoLabel = new JLabel(cpfTexto);
		painelTelaCadastroGerente.add(cpfTextoLabel);
		
		JTextField cpfTextField = new JTextField(10);
		painelTelaCadastroGerente.add(cpfTextField);

		JLabel salarioLiquidoTextoLabel = new JLabel(salarioLiquidoTexto);
		painelTelaCadastroGerente.add(salarioLiquidoTextoLabel);
		
		JTextField salarioLiquidoTextoField = new JTextField(10);
		painelTelaCadastroGerente.add(salarioLiquidoTextoField);

		JLabel regionalTextoLabel = new JLabel(regionalTexto);
		painelTelaCadastroGerente.add(regionalTextoLabel);

		JTextField regionalTextoField = new JTextField(10);
		painelTelaCadastroGerente.add(regionalTextoField);

		JLabel metaRegionalTextoLabel = new JLabel(metaRegionalTexto);
		painelTelaCadastroGerente.add(metaRegionalTextoLabel);
		
		JTextField metaRegionalTextoField = new JTextField(10);
		painelTelaCadastroGerente.add(metaRegionalTextoField);

		JLabel enderecoTextoLabel = new JLabel(enderecoTexto);
		painelTelaCadastroGerente.add(enderecoTextoLabel);
		
		JTextField enderecoTextoField = new JTextField(10);
		painelTelaCadastroGerente.add(enderecoTextoField);

		JButton botaoCadastrar = new JButton("Cadastrar");
		painelTelaCadastroGerente.add(botaoCadastrar);
		
		JButton botaoVoltar = new JButton("Voltar");
		painelTelaCadastroGerente.add(botaoVoltar);
		
		frameTelaCadastroGerente.add(painelTelaCadastroGerente);
		
		frameTelaCadastroGerente.setVisible(true);
		
		TelaCadastroGerenteControle telaCadastroGerenteControle = new TelaCadastroGerenteControle(frameTelaCadastroGerente, frameMenuGerente, nomeTextField, cpfTextField, salarioLiquidoTextoField, regionalTextoField, metaRegionalTextoField, enderecoTextoField ,repositorioGerente);
		botaoCadastrar.addActionListener(telaCadastroGerenteControle);
		botaoVoltar.addActionListener(telaCadastroGerenteControle);
	}
}
