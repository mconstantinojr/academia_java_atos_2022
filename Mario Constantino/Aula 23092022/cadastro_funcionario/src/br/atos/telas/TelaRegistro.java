package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.repositorio.RepositorioFuncionario;
import br.atos.telas.controletelas.TelaRegistroControle;

public class TelaRegistro {

	public void registrarProgramador(JTextField opcaoMenuJText, JFrame frameMenuInicial, RepositorioFuncionario repositorioFuncionario) {
		
		String nomeTexto = "Digite o nome do Funcionario:";
		String cpfTexto = "Digite o CPF:";
		String cargoTexto = "Digite o cargo:";
		
		JFrame frameTelaRegistro = new JFrame();
		frameTelaRegistro.setSize(200,300);
		frameTelaRegistro.setTitle("Inserir Funcionario");
		frameTelaRegistro.setLocation(300,300);
		
		JPanel painelTelaRegistro = new JPanel();
		
		JLabel nomeTextoLabel = new JLabel(nomeTexto);
		painelTelaRegistro.add(nomeTextoLabel);
		
		JLabel cpfTextoLabel = new JLabel(cpfTexto);
		painelTelaRegistro.add(cpfTextoLabel);
		
		JLabel cargoTextoLabel = new JLabel(cargoTexto);
		painelTelaRegistro.add(cargoTextoLabel);
		
		JTextField nomeTextField = new JTextField(10);
		painelTelaRegistro.add(nomeTextField);
		
		JTextField cpfTextField = new JTextField(10);
		painelTelaRegistro.add(cpfTextField);
		
		JTextField cargoTextField = new JTextField(10);
		painelTelaRegistro.add(cargoTextField);
		
		JButton botaoCadastrar = new JButton("Registrar");
		painelTelaRegistro.add(botaoCadastrar);
		
		frameTelaRegistro.add(painelTelaRegistro);
		
		frameTelaRegistro.setVisible(true);
		
		TelaRegistroControle telaRegistroControle = new TelaRegistroControle(frameTelaRegistro, frameMenuInicial, nomeTextField, cpfTextField, cargoTextField, repositorioFuncionario);
		
		botaoCadastrar.addActionListener(telaRegistroControle);
	}
}
