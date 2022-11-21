package br.impacta.telas.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.impacta.model.Programador;
import br.impacta.repositorio.RepositorioProgramador;

public class TelaRegistroControle implements ActionListener {
	
	JFrame frameTelaRegistro;
	JFrame frameMenuInicial;
	
	JTextField nomeTextField;
	JTextField cpfTextField;
	JTextField estadoTextField;
	
	RepositorioProgramador repositorioProgramador;
	
	boolean validarSalvar = false;

	public TelaRegistroControle(JFrame frameTelaRegistro, JFrame frameMenuInicial, JTextField nomeTextField,
			JTextField cpfTextField, JTextField estadoTextField, RepositorioProgramador repositorioProgramador) {
		super();
		this.frameTelaRegistro = frameTelaRegistro;
		this.frameMenuInicial = frameMenuInicial;
		this.nomeTextField = nomeTextField;
		this.cpfTextField = cpfTextField;
		this.estadoTextField = estadoTextField;
		this.repositorioProgramador = repositorioProgramador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Cadastro Realizado");
		acionarSalvar();
		frameMenuInicial.setVisible(true);
		frameTelaRegistro.setVisible(false);
	}
	
	private void acionarSalvar() {
		Programador programador = new Programador();
		programador.setNome(nomeTextField.getText());
		programador.setCpf(cpfTextField.getText());
		programador.setEstado(estadoTextField.getText());
		
		validarSalvar = repositorioProgramador.salvarProgramdor(programador);
		if (validarSalvar) {
			System.out.println(programador.getNome() + "foi registrado com sucesso");
		}else {
			System.out.println("Erro durante o cadastro");
		}
	}
	
	
}
