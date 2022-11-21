package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.TelaAlterarGerente;

public class TelaBuscarGerenteController implements ActionListener {
	
	JFrame frameListarGerente;
	JFrame frameMenuGerente;
	JTextField cpfField;
	
	RepositorioGerente repositorioGerente;
	
	TelaAlterarGerente telaAlterarGerente = new TelaAlterarGerente();
	
	public TelaBuscarGerenteController(JFrame frameListarGerente, JFrame frameMenuGerente, JTextField cpfField,
			RepositorioGerente repositorioGerente) {
		super();
		this.frameListarGerente = frameListarGerente;
		this.frameMenuGerente = frameMenuGerente;
		this.cpfField = cpfField;
		this.repositorioGerente = repositorioGerente;
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			frameListarGerente.setVisible(false);
			frameMenuGerente.setVisible(true);
		} else {
			Gerente gerenteAtual = new Gerente();
			
			gerenteAtual = repositorioGerente.BuscarGerente(cpfField.getText());
			
			if (!(gerenteAtual == null)) {
				frameListarGerente.setVisible(false);
				telaAlterarGerente.alterarGerente(frameMenuGerente, repositorioGerente, gerenteAtual);
			}
			
		}
		
	
	}

}
