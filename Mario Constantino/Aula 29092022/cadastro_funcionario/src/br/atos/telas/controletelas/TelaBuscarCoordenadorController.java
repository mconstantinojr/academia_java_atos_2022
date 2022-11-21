package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.model.Coordenador;
import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioCoordenador;
import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.TelaAlterarCoordenador;
import br.atos.telas.TelaAlterarGerente;

public class TelaBuscarCoordenadorController implements ActionListener {
	
	JFrame frameListarCoordenador;
	JFrame frameMenuCoordenador;
	JTextField cpfField;
	
	RepositorioCoordenador repositorioCoordenador;
	
	TelaAlterarCoordenador telaAlterarCoordenador = new TelaAlterarCoordenador();
	
	public TelaBuscarCoordenadorController(JFrame frameListarCoordenador, JFrame frameMenuCoordenador, JTextField cpfField,
			RepositorioCoordenador repositorioCoordenador) {
		super();
		this.frameListarCoordenador = frameListarCoordenador;
		this.frameMenuCoordenador= frameMenuCoordenador;
		this.cpfField = cpfField;
		this.repositorioCoordenador = repositorioCoordenador;
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			frameListarCoordenador.setVisible(false);
			frameMenuCoordenador.setVisible(true);
		} else {
			Coordenador coordenadorAtual = new Coordenador();
			
			coordenadorAtual = repositorioCoordenador.BuscarCoordenador(cpfField.getText());
			
			if (!(coordenadorAtual == null)) {
				frameListarCoordenador.setVisible(false);
				telaAlterarCoordenador.alterarCoordenador(frameMenuCoordenador, repositorioCoordenador, coordenadorAtual);
			}
			
		}
		
	
	}

}
