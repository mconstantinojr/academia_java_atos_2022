package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.repositorio.RepositorioGerente;

public class TelaDeletarGerenteControle implements ActionListener{

	JFrame frameListarGerente;
	JFrame menuGerenteFrame;
	JTextField cpfField;
	RepositorioGerente repositorioGerente;
	
	boolean validaDelete;
	
	public TelaDeletarGerenteControle(JFrame frameListarGerente, JFrame menuGerenteFrame, JTextField cpfField,
			RepositorioGerente repositorioGerente) {
		super();
		this.frameListarGerente = frameListarGerente;
		this.menuGerenteFrame = menuGerenteFrame;
		this.cpfField = cpfField;
		this.repositorioGerente = repositorioGerente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			menuGerenteFrame.setVisible(true);
			frameListarGerente.setVisible(false);
		} else {
			validaDelete = repositorioGerente.deletarGerente(cpfField.getText());
			
			if(validaDelete) {
				JOptionPane.showMessageDialog(null, "Gerente excluido com Sucesso");
				menuGerenteFrame.setVisible(true);
				frameListarGerente.setVisible(false);
				
			}else {
				JOptionPane.showMessageDialog(null, "Gerente não encontrado!!");
				menuGerenteFrame.setVisible(false);
				frameListarGerente.setVisible(true);
			
			}
			
		}
		
		
	
	}
	
	
	
	
	
	
}
