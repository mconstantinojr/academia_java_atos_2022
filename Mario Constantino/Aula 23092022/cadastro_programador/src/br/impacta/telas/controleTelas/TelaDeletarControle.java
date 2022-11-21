package br.impacta.telas.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.impacta.repositorio.RepositorioProgramador;

public class TelaDeletarControle implements ActionListener {
	
	JFrame frameListarProgramador;
	JFrame menuInicialFrame;
	JTextField cpfField;
	RepositorioProgramador repositorioProgramador;
	boolean validaDelete;
	
	public TelaDeletarControle(JFrame frameListarProgramador, JFrame menuInicialFrame, JTextField cpfField,
			RepositorioProgramador repositorioProgramador) {
		super();
		this.frameListarProgramador = frameListarProgramador;
		this.menuInicialFrame = menuInicialFrame;
		this.cpfField = cpfField;
		this.repositorioProgramador = repositorioProgramador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		validaDelete = repositorioProgramador.deletarProgramador(cpfField.getText());
		if (validaDelete) {
			JOptionPane.showMessageDialog(null, "Programador Excluido com Sucesso");
			menuInicialFrame.setVisible(true);
			frameListarProgramador.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null, "Programador nao excluido");
			menuInicialFrame.setVisible(true);
			frameListarProgramador.setVisible(false);
		}
		
	}
	
	
	
}
