package br.impacta.telas.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.impacta.model.Programador;
import br.impacta.repositorio.RepositorioProgramador;

public class TelaAlterarProgramadorControle implements ActionListener {
	
	JFrame frameListarProgramador;
	JFrame menuInicialFrame;
	JTextField cpfField;
	JTextField nomeField;
	JTextField estadoField;
	RepositorioProgramador repositorioProgramador;
	boolean validaAlterar;
	
	public TelaAlterarProgramadorControle(JFrame frameListarProgramador, JFrame menuInicialFrame, JTextField cpfField,
			JTextField nomeField, JTextField estadoField, RepositorioProgramador repositorioProgramador) {
		super();
		this.frameListarProgramador = frameListarProgramador;
		this.menuInicialFrame = menuInicialFrame;
		this.cpfField = cpfField;
		this.nomeField = nomeField;
		this.estadoField = estadoField;
		this.repositorioProgramador = repositorioProgramador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Programador programadorParaAlterar = new Programador();
		programadorParaAlterar.setCpf(cpfField.getText());
		programadorParaAlterar.setNome(nomeField.getText());
		programadorParaAlterar.setEstado(estadoField.getText());
		validaAlterar = repositorioProgramador.alterarProgramador(programadorParaAlterar);
		if (validaAlterar) {
			JOptionPane.showMessageDialog(null, "Programador Alterado com Sucesso");
			menuInicialFrame.setVisible(true);
			frameListarProgramador.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null, "Programador nao alterado");
			menuInicialFrame.setVisible(true);
			frameListarProgramador.setVisible(false);
		}
		
	}
	
	
	
}
