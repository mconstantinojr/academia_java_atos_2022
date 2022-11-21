package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.repositorio.RepositorioCoordenador;
import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.controletelas.TelaCadastroCoordenadorControle;
import br.atos.telas.controletelas.TelaCadastroGerenteControle;

public class TelaCadastroCoordenador {

	public void registrarCoordenador(JTextField opcaoMenuJText, JFrame frameMenuGerente, RepositorioCoordenador repositorioCoordenador) {
		
		String nomeTexto = "Digite o nome do Coordenador:";
		String cpfTexto = "Digite o CPF:";
		String salarioLiquidoTexto = "Digite o Salario Liquido:";
		String lojaTexto = "Digite a lojs:";
		String metaLojaTexto = "Digite a meta loja:";
		String enderecoTexto = "Digite o endereco:";
		
		JFrame frameTelaCadastroCoordenador = new JFrame();
		frameTelaCadastroCoordenador.setSize(200,300);
		frameTelaCadastroCoordenador.setTitle("Inserir Coordenador");
		frameTelaCadastroCoordenador.setLocation(300,300);
		
		JPanel painelTelaCadastroCoordenador = new JPanel();
		
		JLabel nomeTextoLabel = new JLabel(nomeTexto);
		painelTelaCadastroCoordenador.add(nomeTextoLabel);
		
		JTextField nomeTextField = new JTextField(10);
		painelTelaCadastroCoordenador.add(nomeTextField);
		
		JLabel cpfTextoLabel = new JLabel(cpfTexto);
		painelTelaCadastroCoordenador.add(cpfTextoLabel);
		
		JTextField cpfTextField = new JTextField(10);
		painelTelaCadastroCoordenador.add(cpfTextField);

		JLabel salarioLiquidoTextoLabel = new JLabel(salarioLiquidoTexto);
		painelTelaCadastroCoordenador.add(salarioLiquidoTextoLabel);
		
		JTextField salarioLiquidoTextoField = new JTextField(10);
		painelTelaCadastroCoordenador.add(salarioLiquidoTextoField);

		JLabel lojaTextoLabel = new JLabel(lojaTexto);
		painelTelaCadastroCoordenador.add(lojaTextoLabel);

		JTextField lojaTextoField = new JTextField(10);
		painelTelaCadastroCoordenador.add(lojaTextoField);

		JLabel metaLojaTextoLabel = new JLabel(metaLojaTexto);
		painelTelaCadastroCoordenador.add(metaLojaTextoLabel);
		
		JTextField metaLojaTextoField = new JTextField(10);
		painelTelaCadastroCoordenador.add(metaLojaTextoField);

		JLabel enderecoTextoLabel = new JLabel(enderecoTexto);
		painelTelaCadastroCoordenador.add(enderecoTextoLabel);
		
		JTextField enderecoTextoField = new JTextField(10);
		painelTelaCadastroCoordenador.add(enderecoTextoField);

		JButton botaoCadastrar = new JButton("Cadastrar");
		painelTelaCadastroCoordenador.add(botaoCadastrar);
		
		JButton botaoVoltar = new JButton("Voltar");
		painelTelaCadastroCoordenador.add(botaoVoltar);
		
		frameTelaCadastroCoordenador.add(painelTelaCadastroCoordenador);
		
		frameTelaCadastroCoordenador.setVisible(true);
		
		TelaCadastroCoordenadorControle telaCadastroCoordenadorControle = new TelaCadastroCoordenadorControle(frameTelaCadastroCoordenador, frameMenuGerente, nomeTextField, cpfTextField, salarioLiquidoTextoField, lojaTextoField, metaLojaTextoField, enderecoTextoField ,repositorioCoordenador);
		botaoCadastrar.addActionListener(telaCadastroCoordenadorControle);
		botaoVoltar.addActionListener(telaCadastroCoordenadorControle);
	}
}
