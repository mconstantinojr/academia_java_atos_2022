package br.impacta.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.impacta.repositorio.RepositorioProgramador;
import br.impacta.telas.controleTelas.TelaRegistroControle;

public class TelaRegistro {

	public void registrarProgramador(JTextField opcaoMenuJText, JFrame frameMenuInicial, RepositorioProgramador repositorioProgramador) {
		
		String nomeTexto = "Digite o nome do Programador:";
		String cpfTexto = "Digite o CPF:";
		String estadoTexto = "Digite o estado:";
		
		JFrame frameTelaRegistro = new JFrame();
		frameTelaRegistro.setSize(200,300);
		frameTelaRegistro.setTitle("Inserir Programador");
		frameTelaRegistro.setLocation(300,300);
		
		JPanel painelTelaRegistro = new JPanel();
		
		JLabel nomeTextoLabel = new JLabel(nomeTexto);
		painelTelaRegistro.add(nomeTextoLabel);
		
		JLabel cpfTextoLabel = new JLabel(cpfTexto);
		painelTelaRegistro.add(cpfTextoLabel);
		
		JLabel estadoTextoLabel = new JLabel(estadoTexto);
		painelTelaRegistro.add(estadoTextoLabel);
		
		JTextField nomeTextField = new JTextField(10);
		painelTelaRegistro.add(nomeTextField);
		
		JTextField cpfTextField = new JTextField(10);
		painelTelaRegistro.add(cpfTextField);
		
		JTextField estadoTextField = new JTextField(10);
		painelTelaRegistro.add(estadoTextField);
		
		JButton botaoCadastrar = new JButton("Registrar");
		painelTelaRegistro.add(botaoCadastrar);
		
		frameTelaRegistro.add(painelTelaRegistro);
		
		frameTelaRegistro.setVisible(true);
		
		TelaRegistroControle telaRegistroControle = new TelaRegistroControle(frameTelaRegistro, frameMenuInicial, nomeTextField, cpfTextField, estadoTextField, repositorioProgramador);
		
		botaoCadastrar.addActionListener(telaRegistroControle);
	}
}
