package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.repositorio.RepositorioCoordenador;

public class TelaDeletarCoordenadorControle implements ActionListener{

	JFrame frameListarCoordenador;
	JFrame menuCoordenadorFrame;
	JTextField cpfField;
	RepositorioCoordenador repositorioCoordenador;
	
	boolean validaDelete;
	
	public TelaDeletarCoordenadorControle(JFrame frameListarCoordenador, JFrame menuCoordenadorFrame, JTextField cpfField,
			RepositorioCoordenador repositorioCoordenador) {
		super();
		this.frameListarCoordenador = frameListarCoordenador;
		this.menuCoordenadorFrame = menuCoordenadorFrame;
		this.cpfField = cpfField;
		this.repositorioCoordenador = repositorioCoordenador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			menuCoordenadorFrame.setVisible(true);
			frameListarCoordenador.setVisible(false);
		} else {
			validaDelete = repositorioCoordenador.deletarCoordenador(cpfField.getText());
			
			if(validaDelete) {
				JOptionPane.showMessageDialog(null, "Coordenador excluido com Sucesso");
				menuCoordenadorFrame.setVisible(true);
				frameListarCoordenador.setVisible(false);
				
			}else {
				JOptionPane.showMessageDialog(null, "Coordenador não encontrado!!");
				menuCoordenadorFrame.setVisible(false);
				frameListarCoordenador.setVisible(true);
			
			}
			
		}
		
		
	
	}
	
	
	
	
	
	
}
