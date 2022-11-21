package br.atos.telas;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.telas.controletelas.MenuGerenteCoordenadorControle;

public class MenuGerenteCoordenador {
	public void apresentarMenuGerenteCoordenador() {
		System.out.println("MenuInicial");
		
		String opcaoMenu = null;
		
		String menuInicialTexto = "Menu Gerente/Coordenador";
		String opcaoUmMenuTexto = "[1] Gerente";
		String opcaoDoisMenuTexto = "[2] Coordenador";
		String opcaoTresMenuTexto = "[3] Encerrar";
		
		JFrame frameMenuGerenteCoordenador = new JFrame();
		frameMenuGerenteCoordenador.setSize(200,200);
		frameMenuGerenteCoordenador.setTitle("Cadastro de Funcionario");
		frameMenuGerenteCoordenador.setLocation(300,300);
		
		JPanel panelGerenteCoordenador = new JPanel();
		
		JLabel menuInicialTextoLabel = new JLabel(menuInicialTexto);
		panelGerenteCoordenador.add(menuInicialTextoLabel);
		
		JLabel opcaoUmMenuTextoLabel = new JLabel(opcaoUmMenuTexto);
		panelGerenteCoordenador.add(opcaoUmMenuTextoLabel);
		
		JLabel opcaoDoisMenuTextoLabel = new JLabel(opcaoDoisMenuTexto);
		panelGerenteCoordenador.add(opcaoDoisMenuTextoLabel);
		
		JLabel opcaoTresTextoLabel = new JLabel(opcaoTresMenuTexto);
		panelGerenteCoordenador.add(opcaoTresTextoLabel);

		JTextField opcaoMenuJTextField = new JTextField(10);
		panelGerenteCoordenador.add(opcaoMenuJTextField);
		
		JButton botaoMenu = new JButton("Enviar");
		panelGerenteCoordenador.add(botaoMenu);
		
		
		frameMenuGerenteCoordenador.add(panelGerenteCoordenador);
		frameMenuGerenteCoordenador.setVisible(true);
		
		MenuGerenteCoordenadorControle menuGerenteCoordenadorControle = new MenuGerenteCoordenadorControle(opcaoMenuJTextField, frameMenuGerenteCoordenador);
		botaoMenu.addActionListener(menuGerenteCoordenadorControle);
	}
}