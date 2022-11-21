package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class TelaListarCoordenadorControle implements ActionListener {

	JFrame frameMenuCoordenador;
	JFrame frameListarCoordenador;
	
	public TelaListarCoordenadorControle(JFrame frameMenuCoordenador, JFrame frameListarCoordenador) {
		super();
		this.frameMenuCoordenador = frameMenuCoordenador;
		this.frameListarCoordenador = frameListarCoordenador;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		frameListarCoordenador.setVisible(false);
		frameMenuCoordenador.setVisible(true);
		
	}

	
	
	
	
}
