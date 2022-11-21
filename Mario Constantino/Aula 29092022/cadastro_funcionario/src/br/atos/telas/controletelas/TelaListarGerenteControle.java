package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class TelaListarGerenteControle implements ActionListener {

	JFrame frameMenuGerente;
	JFrame frameListarGerente;
	
	public TelaListarGerenteControle(JFrame frameMenuGerente, JFrame frameListarGerente) {
		super();
		this.frameMenuGerente = frameMenuGerente;
		this.frameListarGerente = frameListarGerente;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		frameListarGerente.setVisible(false);
		frameMenuGerente.setVisible(true);
		
	}

	
	
	
	
}
